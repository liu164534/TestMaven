package com.abcd.beanlife;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @program: TestMaven
 * @description: 一个学生类(Bean), 能体现其生命周期的Bean
 * @author: Liu Xinpeng
 * @create: 2021-05-13 17:11
 **/
public class Student implements BeanNameAware {

    private String name;

    /**
     * 无参构造方法
     */
    public Student() {
        super();
    }

    /**
     * 设置对象属性
     *
     * @param name
     */
    public void setName(String name) {
        System.out.println("设置对象属性setName()...");
        this.name = name;
    }

    // Bean的初始化方法
    public void initStudent() {
        System.out.println("Student Bean:初始化...");
    }

    // Bean 的销毁方法
    public void destroyStudent() {
        System.out.println("Student Bean:销毁...");
    }

    public void play() {
        System.out.println("Student Bean:使用");
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        return "Student [name = " + name + " ] ";
    }

    /**
     * 调用BeanNameAware的setBeanName()
     * 传递Bean的Id
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware的setBeanName()...");
    }
}