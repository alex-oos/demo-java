package cc.blog.alex.threaddemo;

import java.util.concurrent.*;

/**
 * @author: Alex
 * @date: 2023/9/18 下午2:36
 * @Descprition:
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {

        // ExecutorService executorService = Executors.newFixedThreadPool(5);
        //
        // for (int i = 0; i < 5; i++) {
        //
        //     Future<?> submit = executorService.submit(new Runnable() {
        //         @Override
        //         public void run() {
        //
        //             for (int j = 0; j < 10; j++) {
        //                 System.out.println(Thread.currentThread().getName() + "   " + j);
        //             }
        //         }
        //     });
        // }
        // executorService.shutdown();

        int cpuNumber = Runtime.getRuntime().availableProcessors();

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(cpuNumber * 2, cpuNumber * 4, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            int i = 1;
            System.out.println("cc/blog/alex" + i);
            i++;
            System.out.println("当前线程名称是：" + Thread.currentThread().getName());
            return i;
        }, threadPoolExecutor);
        integerCompletableFuture.thenApplyAsync((res) -> {
            System.out.println("当前线程名称是：" + Thread.currentThread().getName());
            System.out.println(res);
            return 3;
        });
        integerCompletableFuture.thenAcceptAsync((res) -> {
            System.out.println("当前线程名称是：" + Thread.currentThread().getName());
            System.out.println(res);

        });

    }

}
