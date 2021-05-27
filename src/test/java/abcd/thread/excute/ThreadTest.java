package abcd.thread.excute;

import com.abcd.thread.excute.*;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

/**
 * @program: TestMaven
 * @description:
 * @author: Liu Xinpeng
 * @create: 2021-05-24 18:14
 **/
public class ThreadTest {

    /**
     * 测试循环调用线程
     */
    @Test
    public void threadTest() {
        ThreadTwo threadOne = new ThreadTwo();
        ThreadTwo threadTwo = new ThreadTwo();
        ThreadTwo threadThree = new ThreadTwo();

        /**
         * 在程序中一个Thread对象多次调用.start()方法，就会产生java.lang.lllegalThreadStateException异常
         * 解决办法：不要extends Thread ,要implements Runnable 接口，通过匿名对象
         * 如：new Thread(new MyThread()).start()
         */
        for(int i = 0; i < 1000; i++) {
            new Thread(threadOne).start();
            new Thread(threadTwo).start();
            new Thread(threadThree).start();
        }
    }


    /**
     * 多线程测试卖🎫
     */
    @Test
    public void ticketTest() {
        // 模拟两个🚉同时在卖票，竞争共同的资源
        Thread ticketOne = new Thread(new TicketThread());
        ticketOne.start();
        Thread threadTwo = new Thread(new TicketThread());
        threadTwo.start();

        /**
         * 这样的执行结果是有问题的，线程竞争的过程中，cpu切换十分频繁
         * 可能会出现有票被重复卖出，或者是有的票没有被卖出的情况
         * 因此需要引入线程锁的概念来解决线程同步的问题
         */
    }

    /**
     * 加锁的第一种方式，通过执行结果可以看出加锁之后票卖出的顺序是按数字的顺序
     * 并且没有多卖和漏卖的情况
     */
    @Test
    public void ticketThreadSyn() {
        // 通过synchronized 加锁
        Thread threadOne = new Thread(new TicketThreadSyn());
        threadOne.start();
        Thread threadTwo = new Thread(new TicketThreadSyn());
        threadTwo.start();
    }

    /**
     * synchronized加锁实现的第二种方式
     */
    @Test
    public void ticketThreadSynStr() {
        Thread threadOne = new Thread(new TicketThreadSynStr());
        threadOne.start();
        Thread threadTwo = new Thread(new TicketThreadSynStr());
        threadTwo.start();
    }


}