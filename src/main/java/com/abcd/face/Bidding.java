package com.abcd.face;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: TestMaven
 * @description: 拍卖
 * @author: Liu Xinpeng
 * @create: 2021-07-01 15:24
 **/
public class Bidding {

    // 竞拍者的编号
    private volatile int perNo = 0;
    // 竞拍的次数
    private volatile int count = 1;
    // 起拍价格
    private volatile int money = 4000;

    private static final Object lock = new Object();

    private static final ExecutorService executors = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Bidding bidding = new Bidding();
        // 随机生成多个用户进行竞争拍卖
        int n = new Random().nextInt(10) + 2;
        for (int i = 1 ;i <= n; i++) {
            executors.execute(bidding.new BiddingThread("客户" + i +"：", i));
        }
    }

    class BiddingThread implements Runnable {
        String name;
        int number;

        public BiddingThread(String name,int number) {
            this.name = name;
            this.number = number;

        }

        @Override
        public void run() {
            try{
                synchronized (lock) {
                    while (count <= 1000) {
                        while (perNo == number) {
                            // 不能连续出价
                            lock.wait();
                        }
                        if (count > 1000 ) {
                            break;
                        }
                        int addPrice = biddingPrice();
                        money += addPrice;
                        System.out.println("第" + count + "次出价" + name + "总价" + money + "加价" + addPrice);
                        ++count;
                        perNo = number;
                        lock.notifyAll();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        /**
         * 随机计算价格的方法
         * @return
         */
        public int biddingPrice() {
            Random random = new Random();
            return 1 + random.nextInt(200);
        }

    }


}