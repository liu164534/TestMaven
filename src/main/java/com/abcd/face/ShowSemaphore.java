package com.abcd.face;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author 3个线程打印数
 *
 */
public class ShowSemaphore {

    //计数器
    final static AtomicInteger count = new AtomicInteger(0);
    //信号量
    static Semaphore sp3 = new Semaphore(1);
    static Semaphore sp5 = new Semaphore(1);
    static Semaphore other = new Semaphore(1);

    public static void main(String[] args) {


        Thread threadA  =new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    int p =  count.get();
                    if(p>100){
                        break;
                    }
                    if((p % 3 == 0) && (p % 5 != 0)) {
                        sp3.acquireUninterruptibly();
                        System.out.println("threadA :" + p);
                        count.getAndIncrement();
                    }
                    sp5.release();
                    other.release();
                }
            }
        });

        Thread threadB   =new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    int p =  count.get();
                    if(p>100){
                        break;
                    }
                    if((p % 5 == 0) && (p % 3 != 0)) {
                        sp5.acquireUninterruptibly();
                        System.out.println("threadB : " + p);
                        count.getAndIncrement();
                    }
                    sp3.release();
                    other.release();
                }
            }
        });

        Thread threadC   =new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    int p = count.get();
                    if(p>100){
                        break;
                    }
                    if(((p % 5 != 0) && (p % 3 != 0)||(p % 15 == 0))) {
                        other.acquireUninterruptibly();
                        System.out.println("threadc : " + p);
                        count.getAndIncrement();
                    }
                    sp3.release();
                    sp5.release();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();


    }

}