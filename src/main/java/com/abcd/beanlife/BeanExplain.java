package com.abcd.beanlife;


/**
 * @program: TestMaven
 * @description: Bean生命周期的说明
 * @author: Liu Xinpeng
 * @create: 2021-05-17 14:28
 **/
public class BeanExplain {

    /**
     * 在Ioc容器启动之后，并不会马上就实例化相应的bean,此时容器仅仅拥有对象的BeanDefinition(BeanDefinition:是容器依赖某些工具加载
     * xml配置信息进行解析和分析，并将分析后的信息编组为相应的BeanDefinition).只有当getBean()调用的时才有可能触发Bean实例化阶段的活动
     *
     * 为什么说有可能触发bean的实例化阶段？
     *
     * 因为当对应某个bean定义的getBean()方法第一次被调用的时候，不管是显示的还是隐式的，Bean实例化阶段才会触发，第二次被调用则会直接
     * 返回容器缓存的第一次实例化完的对象实例(因为默认是singleton单例，当然，这里的情况prototype类型的bean除外)
     */


    /**
     * bean的生命周期大致九步
     * 1。实例化Bean对象（通过构造方法或者工厂方法）
     * 2。设置对象属性（setter等）（依赖注入）
     * 3。如果Bean实现了BeanNameAware接口，工厂调用Bean的setBeanName()方法传递Bean的Id.(和4均属于检查Aware接口)
     * 4。如果Bean实现了BeanFactoryAware接口，工厂调用setBeanFactory()方法传入工厂自身
     * 5。将Bean实例传递给Bean的前置处理器的postProcessBeforeInitialization(Object bean,String beanName)方法
     * 6。调用Bean的初始化方法
     * 7。将Bean实例传递给Bean的后置处理器的postProcessAfterInitialization(Object bean,String beanName)方法
     * 8。使用Bean
     * 9。容器关闭之前，调用Bean的销毁方法
     */

    /**
     * Bean的后置处理器是为了对bean的一个增强
     * 分别在Bean的初始化前后对Bean对象提供自己的实例化逻辑
     * - 实现BeanPostProcessor接口
     *  -postProcessBeforeInitialization方法
     *  -postProcessAfterInitialization方法
     */

    /**
     * 在Spring中，那些组成应用程序的主体及由Spring Ioc容器所管理的对象，被称为bean。简单的说，bean就是由Ioc容器初始化、装配及管理
     * 的对象，除此之外，bean就与应用程序中的其他对象没有什么区别了。而bean的定义以及bean相互间的依赖关系将通过配置元数据来描述。
     *
     * Spring中bean默认都是单例的，对于web来说，web容器对于每个用户请求都创建一个单独的Sevlet线程来处理请求，引入Spring 框架之后，
     * 每个Action都是单例的，那么对于Spring托管的单例Service Bean，Spring的单例是基于BeanFactory也就是Spring容器的，单例bean
     * 在此容器内只有一个，Java的单例是基于JVM的，每个JVM内只有一个实例
     */

    /**
     * Bean的作用域
     *
     * singleton ：在springIoc容器中仅存在一个Bean实例，Bean以单例的形式存在，默认值
     * prototype : 每次从容器中调用Bean时，都会返回一个新的实例，即每次调用getBean()时，想当于执行new XxxBean()
     * request : 每次HTTP请求都会创建一个新的Bean,该作用域仅适用于WebApplicationContext环境
     * session : 同一个HTTP Session 共享一个Bean,不同Session使用不同Bean,仅适用于WebApplicationContext环境
     * globalSession : 一般用于Portlet应用环境，该作用域仅适用于WebApplicationContext环境
     */

    /**
     * 1 servlet容器需要在应用项目启动的时候，给应用初始化一个ServletContext作为公共环境容器存放公共信息
     * 2 WebApplicationContext,是继承ApplicationContext的一个接口，扩展了ApplicationContext,是专门为Web应用准备的，它允许从相对于Web根目录
     * 的路径中装载配置文件完成初始化
     * 3 在非Web应用下，Bean只有singleton和prototype两种作用域，WebApplicationContext为Bean添加了三个作用域
     */
}