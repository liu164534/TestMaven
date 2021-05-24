package abcd.thread.excute;

import com.abcd.thread.excute.ThreadOne;
import com.abcd.thread.excute.ThreadTwo;
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

        /**
         * 在程序中一个Thread对象多次调用.start()方法，就会产生java.lang.lllegalThreadStateException异常
         * 解决办法：不要extends Thread ,要implements Runnable 接口，通过匿名对象
         * 如：new Thread(new MyThread()).start()
         */

        for(int i = 0; i < 100; i++) {
            new Thread(threadOne).start();
            new Thread(threadTwo).start();
        }

    }
}