package com.abcd.thread.excute;

/**
 * @program: TestMaven
 * @description:
 * @author: Liu Xinpeng
 * @create: 2021-05-24 18:09
 **/
public class ThreadOne extends Thread{

    int count = 0;

    public void run() {
        count ++;
        System.out.println(count);
    }
}