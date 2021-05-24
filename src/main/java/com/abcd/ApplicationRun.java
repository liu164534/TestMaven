package com.abcd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: TestMaven
 * @description: 启动类
 * @author: Liu Xinpeng
 * @create: 2021-04-22 16:50
 **/
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }

}


/**
 @SpringBootApplication: 是一个复合注解，在这个注解中包含了其他注解，那么这个注解就叫复合注解
 @Target({ElementType.TYPE})
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 @Inherited
 @SpringBootConfiguration
 @EnableAutoConfiguration
 @ComponentScan(
 excludeFilters = {@Filter(
 type = FilterType.CUSTOM,
 classes = {TypeExcludeFilter.class}
 ), @Filter(
 type = FilterType.CUSTOM,
 classes = {AutoConfigurationExcludeFilter.class}
 )}
 )

 @Target({ElementType.TYPE})
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 这三个注解只是把一个普通类标识为一个注解

 1 @SpringBootConfiguration: 是springboot的配置注解，就是spring自带的配置先加载进来
 2 @EnableAutoConfiguration:(META_INF/spring.factories) 自动装配注解 Spring框架，其实单独一个Spring框架没有任何作用
 也不能正常运行，如果想要连数据库--》需要集成Mybatis 或者一些其他的框架
 springboot框架非常方便--》因为springboot已经把所需要的很多框架都自动集成进来了，不需要在去自己编写配置文件，springboot
 会把之前所用的xml文件转换为java类来进行完成
 比如在springboot框架中，需要用到mybatis，如果想把框架自动的装配好，就必须要用到@EnableAutoCoufiguration注解
 这就是自动装配
 3 @ComponentScan:其实是一个扫描器
 springmvc扫描的是service层，spring扫描的是controller层，扫描@Bean(就是为了实现依赖注入)
 @CompomentSacn 注解获取到@Bean注解所返回的值后，就会通过SpringBoot框架，让Springboot生成出一个对象，依赖注入
 4.自动装配
 一定会用到@EnableAutoConfiguration
 -->这个注解继续看会发现仍然是一个复合注解
 @Import:导入
 application.xml:
 <import source="mybatis.xml" />
 因为在spring中<import />标签导入的是xml文件，到了springboot年代之后
 这些xml完全被java类所替代了，所以在springboot中@Import注解所导入的
 内容必须是java类，不能是xml文件
 EnableAutoConfigurationImportSelector:
 自动按照某种规定来配置选择器--->通过某种规定来进行选择自动装配的方式
 spring所默认提供的装配方式就是spring.factories
 先约定好几种规则，根据自己的需要使用规则去选择
 这就是springboot非常著名的一个特点(约定优于配置)(springboot面试高频题)
 springboot中其实已经集成进来了很多很多的框架，那么这些都不是springboot公司所开发的，只是把他们给集成进来了
 springboot最后就规定/定义了很多的接口，如果说自己写的框架想集成进springboot，那么就必须要
 实现这些接口，也就是说只要实现了这些接口，就已经把自己的框架整合到springboot中
 EnableAutoConfigurationImportSelector extends AutoConfigurationImportSelector
 --->getCandidateConfigurations():通过某一个条件来获取配置
 List<String> configurations = SpringFactoriesLoader.loadFactoryNames(this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
 loadFactoryNames()这个方法就是把spring.factories文件中的所有内容给读取出来
 存放到List集合中<String>
 Assert:断言--->断言就是省略了判断/或者说可以叫封装了判断
 Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.");
 notEmpty:字面意思上理解为不为null，其实是如果是空则需要怎么办
 正好和if/else相反
 configurations = xxxx;
 if(null != configurations) {
 return configurations;
 } else {
 return "No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.";
 }
 这个spring.factories文件里面其实并没有很高深的代码，只是放入了很多的类的全限定名
 橘红色的代码不能改，这是springboot的强制规定，必须要这么写
 绿色的代码就是各个框架的配置类
 那么这么一个配置类，就是之前所学习的整合spring的框架的配置文件
 (mybatis需要整合spring--->mybatis.xml-->MybatisConfig.java)
 **/

/**

 (美团)2.如何禁用特定的自动配置类？(考验细节问题，对于springboot源码的理解)
 假设自己开发一个jdbc框架，肯定会用到数据源(目前的数据源都是德鲁伊)，
 都会用自己数据源
 德鲁伊数据源做大众化(多兼容)--->必定要损失性能(不能按照定制化来开发，面向
 的是整个世界)
 要让springboot使用我自己所写的数据源，不再使用springboot所自带的数据源了
 在这里需要禁用掉springboot所自带的数据源
 @EnableAutoConfiguration注解:本来叫做自动装配
 exclude:排除
 Class<?>[] exclude();
 String[] excludeName();
 这两个所实现的效果是一模一样的，并没有什么不同
 @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, Test.class})
 就相当于不再加载DataSourceAutoConfiguration类了
 @EnableAutoConfiguration(excludeName = {"所需要排除配置类的全限定名","","com.aaa.lee.springboot.config.Test"})
 Test类的全限定名就叫做:com.aaa.lee.springboot.config.Test
 Class.forName("com.xxx.mysql...");
 (!!!一定是要配置在启动上的!!!)
 @SpringBootApplication
 @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
 报错：
 为什么报错呢？
 @SpringBootApplication--->包含了@EnableAutoConfiguration--->不允许
 额外再写一个
 @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

 以上的写法已经完全排除掉了，没有什么问题了，但是当项目开发完毕-->最终会打包上线-->.java文件全部会被编译成.class文件--->不允许修改

 我可以把这个东西写在application.properties/yml文件中，使用配置的形式来实现排除
 properties:
 spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
 yml:
 spring:
 autoconfigure:
 exlude: org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
 **/


/**

 Redis的持久化机制
 RDB(快照)-->照相--->就叫做覆盖
 AOF(追加)-->就在最后的数据进行添加

 (非常高频，问到redis必面)4.什么是redis的缓存穿透，如果解决？
 开发中一定会用，也可以说必须会用到
 3.1.什么是缓存穿透(说白了就是绕过缓存，不再访问缓存):
 有客户端查询数据，发现缓存中没有数据，而且数据库中也没有数据
 (redis.get("user")--->user这个key根本就不存在)，如果当并发特别大的时候，就导致要大量的重复去查
 (!!!!当查询的次数很多的时候(在非常短的时间内，查询出的空的次数非常多的时候)，redis就会进入自我保护状态)(redis不论并发多大，redis没有宕机过(单线程支撑高并发))，这个时候就不会再让查询请求查询了，直接会去查数据库(缓存命中率)
 case穿透:
 int i = 2;
 switch(i){
 case 1 : "今天吃红烧肉";

 case 2 : "今天吃排骨";

 case 3 : "今天吃牛排";
 }

 如果解决缓存穿透:
 两种解决方案:
 一(装逼神器):使用的是布隆过滤器
 先规定好，redis集群中可能会存入的数据(商品信息，就规定商品信息可能会存入，身份证号，就规定身份证号可能会存入，如果两个都有可能，则都规定)
 规定好之后，寻找这些数据所对应哈希值的所有可能(eg:可乐m1--->所有排列可能性全部列出来--->可乐，可乐m，可乐m1，可m...)
 把列完所有可能性的数据全部转换为哈希值，再把这些所有可能出现的哈希值(非常大)，存入到一个非常非常大的bitmap中，当有一个根本不可能的查询数据过来的时候，bitmap会直接拦截，不会让他去查询缓存(redis.get("goods"))
 MD5的加密方式就是使用的是哈希值加密(SimpleAuthenticationInfo("username"/user,密码,盐值,this.getName()))
 eg:
 密码-->zhangsan123456--=
 先把明文转换成char类型的数组-->char[] = {'z', 'h', 'a', 'n'...}
 --->再根据散列算法(自己百度)--->最终获取到每一个char字符的坐标值
 --->获取完坐标值之后来进行替换这个char类型的字符
 z --> 12ki(哈希值)
 h --> llo9
 a --> mj76
 n --> gghyu7-
 明文密码zhan --> 12killo9mh76gghyu7-
 zanh,zahn....
 在数据库中有一种索引bitmap就是位图索引

 二:

 redis的哨兵模式和集群模式是什么？
 不要特别关注哨兵模式，现在很少有公司在用
 (但是得知道他是什么，面试有可能问到(30-45%))
 现在几乎所有的公司都是三主三从
 **/