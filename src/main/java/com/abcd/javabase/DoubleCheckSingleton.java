package com.abcd.javabase;

/**
 * @program: TestMaven
 * @description: 双重检测锁单例模式
 * @author: Liu Xinpeng
 * @create: 2021-06-24 14:14
 **/
public class DoubleCheckSingleton {


    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {};

    /**
     * 使用了两个判断，double-check 并且同步的不是方法是代码块
     * @return
     */
    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                 instance = new DoubleCheckSingleton();
            }
        }
        return instance;
    }


}