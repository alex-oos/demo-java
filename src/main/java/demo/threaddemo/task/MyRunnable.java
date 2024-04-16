package src.main.java.demo.threaddemo.task;

public class MyRunnable implements Runnable {

    private int taskId;


    public MyRunnable(int taskId) {

        this.taskId = taskId;
    }

    @Override
    public void run() {

        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName() + ",线程状态为：" + Thread.currentThread().getState() + ",Task is :" + taskId);
            Thread.sleep(1000);
            System.out.println("Task " + taskId + " completed.");
            if (taskId == 5) {
                throw new RuntimeException("Exception occurred in task " + taskId);
            }


        } catch (InterruptedException e) {
            // 检查线程是否被中断
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "线程状态为：" + Thread.currentThread().getState());
            System.out.println("Task " + taskId + " was interrupted.");
            System.out.println("thread state is  " + Thread.currentThread().getState());
        } catch (Exception e) {
            // 处理任务异常
            System.out.println("Task " + taskId + " encountered an exception: " + e.getMessage());

        }
    }

}
