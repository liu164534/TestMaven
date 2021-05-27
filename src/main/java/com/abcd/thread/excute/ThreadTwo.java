package com.abcd.thread.excute;

/**
 * @program: TestMaven
 * @description:
 * @author: Liu Xinpeng
 * @create: 2021-05-24 18:09
 **/
public class ThreadTwo implements Runnable{

    static int count = 0;

    @Override
    public void run() {
        count ++;
        System.out.println(count);
    }
}