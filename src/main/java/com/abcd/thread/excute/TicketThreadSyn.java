package com.abcd.thread.excute;

/**
 * @program: TestMaven
 * @description: 多线程卖票加锁实现的第一种方式
 * @author: Liu Xinpeng
 * @create: 2021-05-27 16:32
 **/
public class TicketThreadSyn extends Thread{

    public static int ticket = 100;

    public void run() {
        while (true) {
            /**
             * synchronized 的作用是它所包含的代码部分，要么全部执行完，要么全部不执行
             * synchronized 即可修饰代码块也可修饰函数
             * 如果是锁整个方法的话，例如public synchronized void run() {}
             * 但是对于这个售票案例，是多个线程之间进行竞争售票，不易将整个方法锁起来
             * 如果synchronized修饰的是整个函数 synchronized修饰函数不需要传入字符串参数，默认是this
             */
            // 在需要加锁保证完整性的代码块旁边加上synchronized(""){}包裹代码块，即可锁起来该部分代码，（）内字符串随便定义
            synchronized ("") {
                if (ticket > 0) {
                    System.out.println("第" + Thread.currentThread().getName() + "个车站正在卖出第" +
                            (101 - ticket) + "张车票");
                    -- ticket;
                } else {
                    break;
                }
            }
        }
    }
}