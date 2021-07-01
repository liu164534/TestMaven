package com.abcd.face;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: TestMaven
 * @description: 三个线程打印数据，
 * @author: Liu Xinpeng
 * @create: 2021-07-01 16:06
 **/
public class ShowNumber {

    // 计数器
   final static AtomicInteger count  =   new AtomicInteger(0);

   // 信号量
    static Semaphore spA = new Semaphore(1);
    static Semaphore spB = new Semaphore(1);
    static Semaphore spC = new Semaphore(1);

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    int num = count.get();
                    if (num > 100) {
                        break;
                    }
                    if ((num % 3 == 0 ) && (num % 5 != 0 )){
                        spA.acquireUninterruptibly();
                        System.out.println("ThreadA" + num);
                        count.getAndIncrement();
                    }
                    // 释放许可
                    spB.release();
                    spC.release();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    int num = count.get();
                    if (num > 100) {
                        break;
                    }
                    if ((num % 3 != 0 ) && (num % 5 == 0 )){
                        spB.acquireUninterruptibly();
                        System.out.println("ThreadB" + num);
                        count.getAndIncrement();
                    }
                    spA.release();
                    spC.release();
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    int num = count.get();
                    if (num > 100) {
                        break;
                    }
                    if ((num % 3 != 0 ) && (num % 5 != 0 ) || (num % 15 == 0)){
                        spC.acquireUninterruptibly();
                        System.out.println("ThreadC" + num);
                        count.getAndIncrement();
                    }
                    spB.release();
                    spA.release();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

    }
}