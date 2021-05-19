package com.abcd.thread;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: TestMaven
 * @description: 实现Callable接口实现多线程
 * @author: Liu Xinpeng
 * @create: 2021-05-19 15:18
 **/
public class ThreadCallableTest {


    /**
     * 使用ExecutorService 、Callable、Future实现有返回结果的多线程
     * ExecutorService、Callable、Future之这几个对象都是属于Executor框架中的功能类
     * 可返回值的任务必须实现Callable接口，类似的，无返回值的任务必须实现Runnable接口
     * 执行Callable任务后，可以获取一个Future的对象，在该对象上调用get就可以获取到Callable任务返回
     * 的Object了，再结合线程池接口ExecutorService就可以实现有返回值的多线程
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

            System.out.println("—————程序开始运行—————");
            Date dateStart = new Date();

            int taskSize = 500;
            // 创建线程池
            ExecutorService pool = Executors.newFixedThreadPool(taskSize);
            // 创建多个有返回值的任务
            List<Future> futures = new ArrayList<Future>();
            for (int i = 0; i < taskSize; i++) {
                MyCallable myCallable = new MyCallable(i + " ");
                // 执行任务并获得Future对象
                Future<Object> future = pool.submit(myCallable);
                futures.add(future);
            }
            // 关闭线程池
            pool.shutdown();

            // 获取所有并发任务的运行结果
            for (Future future : futures) {
                // 从Future对象上获取任务的返回值，并输出到控制台
                System.out.println(">>>" + future.get().toString());
            }

            Date dateEnd = new Date();
            System.out.println("----程序运行结束----，程序运行时间「" + (dateEnd.getTime() - dateStart.getTime()) + "毫秒」");
        }
    }


    class MyCallable implements Callable<Object> {

        private String taskName;

        public MyCallable(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public Object call() throws Exception {

            System.out.println(">>>" + taskName + "任务启动");
            Date dateTmpA = new Date();
            // 休眠一秒钟
            Thread.sleep(1000);
            Date dateTmpB = new Date();
            long time = dateTmpB.getTime() - dateTmpA.getTime();
            return taskName + "任务执行时间「" + time + "毫秒」";
        }
}