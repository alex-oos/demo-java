package demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/3/15 下午5:08
 */
public class ScheduleTask {

    // https://blog.csdn.net/qq_42778001/article/details/123060814
    // 定时任务使用方法
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        System.out.println("当前时间为：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        service.schedule(() -> {
            System.out.println("我是使用schedule方法执行");
            Thread thread = Thread.currentThread();
            System.out.println("我是间隔1s执行的任务，线程名称为：" + thread.getName() + ",线程ID为：" + thread.getId() + ",当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }, 1, TimeUnit.SECONDS);  // 延1秒后开始执行

        service.schedule(new Runnable() {
            @Override
            public void run() {

                System.out.println("我是使用schedule方法执行");
                Thread thread = Thread.currentThread();
                System.out.println("我是间隔1s执行的任务，线程名称为：" + thread.getName() + ",线程ID为：" + thread.getId() + ",当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
        }, 1, TimeUnit.SECONDS);  // 延1秒后开始执行

        ScheduledFuture<Object> future = service.schedule(new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                System.out.println("我是使用schedule方法执行");
                Thread thread = Thread.currentThread();
                System.out.println("我是间隔1s执行的任务，线程名称为：" + thread.getName() + ",线程ID为：" + thread.getId() + ",当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                return null;
            }
        }, 1, TimeUnit.SECONDS);// 延1秒后开始执行

        Object o = future.get();
        System.out.println(o);


        service.scheduleAtFixedRate(() -> {
            System.out.println("我是使用scheduleAtFixedRate方法执行");
            Thread thread = Thread.currentThread();
            System.out.println("我是间隔1s执行的任务，线程名称为：" + thread.getName() + ",线程ID为：" + thread.getId() + ",当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 0, 1, TimeUnit.SECONDS);  // 第一次延迟0秒执行，每隔1秒执行一次
        //
        service.scheduleWithFixedDelay(() -> {
            System.out.println("我是使用scheduleWithFixedDelay方法执行");
            Thread thread = Thread.currentThread();
            System.out.println("我是间隔1s执行的任务，线程名称为：" + thread.getName() + ",线程ID为：" + thread.getId() + ",当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }, 0, 1, TimeUnit.SECONDS);  // 第一次延迟0秒执行，每隔1秒执行一次


    }

}
