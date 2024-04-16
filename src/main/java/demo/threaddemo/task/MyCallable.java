package src.main.java.demo.threaddemo.task;


import java.util.concurrent.Callable;

public class MyCallable implements Callable<Void> {

    @Override
    public Void call() throws Exception {

        Thread thread = Thread.currentThread();

        System.out.println("thread name is :" + thread.getName() + "thread status is :" + thread.getState());

        return null;
    }

}
