package src.main.java.demo.threaddemo.task;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {

    private int taskId;


    public MyRunnable(int taskId) {

        this.taskId = taskId;
    }

    @Override
    public void run() {


        System.out.println("线程名称为：" + Thread.currentThread().getName() + ",线程状态为：" + Thread.currentThread().getState() + ",Task is :" + taskId);
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task " + taskId + " completed.");
        if (taskId % 7 == 0) {
            throw new RuntimeException("Exception occurred in task " + taskId);
        }


    }

}
