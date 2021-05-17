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
}