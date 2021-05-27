package com.abcd.thread.excute;

/**
 * @program: TestMaven
 * @description: 通过synchronized代码块加锁的第二种写法
 * @author: Liu Xinpeng
 * @create: 2021-05-27 16:50
 **/
public class TicketThreadSynStr implements Runnable{

    public static int ticket = 10000;

    /**
     * 提取出来可以提高可维护性，同时定义为static类型的静态变量 str是公共的
     * 如果不定义成static静态的，则两个线程各自有各自的str,那么大家竞争的就不是同一个资源
     */


    public static String str = "abc";

    @Override
    public void run() {
        while (true) {
            synchronized (str) {
                if (ticket > 0) {
                    System.out.println("第" + Thread.currentThread().getName() + "个车站正在卖出第" +
                            (10001 - ticket) + "张车票");
                    -- ticket;
                } else {
                    break;
                }
            }
        }


    }
}