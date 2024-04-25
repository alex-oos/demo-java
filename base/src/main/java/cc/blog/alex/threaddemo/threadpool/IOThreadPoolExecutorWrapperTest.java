package cc.blog.alex.threaddemo.threadpool;

import cc.blog.alex.threaddemo.task.MyRunnable;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class IOThreadPoolExecutorWrapperTest {

    private IOThreadPoolExecutorWrapper wrapper;

    @Before
    public void setUp() {
        wrapper = new IOThreadPoolExecutorWrapper(10,20, 30L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), "upload-thread-pool");
    }

    @Test
    public void test() {
        for (int j = 0; j < 2; j++) {
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            for (int i = 1; i < 50; i++) {
                futures.add(CompletableFuture.runAsync(new MyRunnable(i), wrapper.getThreadPoolExecutor()));
            }
            futures.forEach(e -> {
                try {
                    e.get();
                } catch (InterruptedException | ExecutionException ex) {
                    wrapper.clear();
                    // log.error("errorMessage: {}", ex.getMessage());
                    System.out.println("errorMessage"+ex.getMessage());
                }
            });
        }
    }

}
