package com.abcd.thread;

/**
 * @program: TestMaven
 * @description: 继承Thread类实现多线程
 * 本质上Thread类也是实现了Runnable接口的一个实例，它代表了一个线程的实例
 * 并且，启动线程的唯一方式机会通过Thread类的start()实例方法。start()方法是一个native()方法，
 * 它将启动一个新的线程，并执行run()方法。
 * @author: Liu Xinpeng
 * @create: 2021-05-18 17:24
 **/
public class MyThreadA extends Thread {


    /**
     * 通过继承Thread类，复写run()方法，就可以启动新线程并执行自己定义的run()方法
     */
    public void run() {
        System.out.println("MyThreadA.run()");
    }
}