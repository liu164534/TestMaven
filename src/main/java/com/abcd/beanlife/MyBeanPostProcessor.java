package com.abcd.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @program: TestMaven
 * @description: Bean的后置处理器
 *  分别在bean的初始化前后对bean对象提供自己的实例化逻辑
 *  postProcessAfterInitialization:初始化之后对bean进行增强处理
 *  postProcessBeforeInitialization:初始化之前对bean进行增强处理
 * @author: Liu Xinpeng
 * @create: 2021-05-17 17:02
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     *  对初始化之后的bean进行处理
     * @param bean 即将初始化的bean
     * @param beanName bean的名称
     * @return 返回给用户的那个bean，可以修改bean也可以返回一个新的bean
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Student student = null;
        System.out.println("对初始化之后的bean进行处理，将Bean的成员变量值修改了");
        if("name".equals(beanName) || bean instanceof Student) {
            student = (Student) bean;
            student.setName("ABCD");
        }
        return student;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("对初始化之前的Bean进行处理，此时我的name为:" + bean);
        return bean;
    }
}