package com.abcd.thread.base;

/**
 * @program: TestMaven
 * @description: 实现Runnable接口实现多线程
 * 如果一个类已经继承另一个类，就无法直接extends Thread ，此时必须实现一个Runnable接口
 * @author: Liu Xinpeng
 * @create: 2021-05-18 17:49
 **/
public class MyThreadB extends BaseThread implements Runnable {


    @Override
    public void run() {
        System.out.println("MyThreadB.run()");
    }
}