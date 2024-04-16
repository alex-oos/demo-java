package src.main.java.demo.threaddemo.threadpool;


import src.main.java.demo.threaddemo.task.MyRunnable;

import java.util.concurrent.*;

public class CusTomThreadPoolTest {


    public static void main(String[] args) {
        // 创建线程池
        int cpuNumber = 1;
        CustomThreadPool executor = new CustomThreadPool(cpuNumber * 2, cpuNumber * 4, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), "ioThreadPool");

        // 提交一些任务
        for (int i = 0; i < 10; i++) {
            executor.getThreadPoolExecutor().submit(new MyRunnable(i));
        }

        executor.clearAllTask();


        System.out.println("新的线程池开始运行，");
        for (int i = 50; i < 100; i++) {
            executor.getThreadPoolExecutor().submit(new MyRunnable(i));

        }




    }

}
