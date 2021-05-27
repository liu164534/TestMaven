package com.abcd.thread.excute;

/**
 * @program: TestMaven
 * @description: 多线程卖票问题
 * @author: Liu Xinpeng
 * @create: 2021-05-27 16:16
 **/
public class TicketThread implements Runnable{

    /**
     * 这个变量需要修改为static静态的,将这个变量对多个线程共享
     */
    // 初识票数量
    public static int ticket = 100;

    public void run() {
        while (true) {
            if(ticket > 0) {
                System.out.println("第" + Thread.currentThread().getName() + "个车站正在卖出第" +
                        (101 - ticket) + "张车票");
                -- ticket;
            } else {
                break;
            }
        }

    }
}
