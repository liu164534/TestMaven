package com.abcd.thread.base;

/**
 * @program: TestMaven
 * @description: 测试
 * @author: Liu Xinpeng
 * @create: 2021-05-18 17:25
 **/
public class ThreadTest {
    public static void main(String[] args) {

        // 继承Thread
        MyThreadA myThreadA = new MyThreadA();
        myThreadA.start();
        // 实现Runnable接口
        MyThreadB myThreadB = new MyThreadB();
        Thread thread = new Thread(myThreadB);
        thread.start();
    }
}