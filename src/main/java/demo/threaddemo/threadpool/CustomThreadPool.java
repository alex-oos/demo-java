package src.main.java.demo.threaddemo.threadpool;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.*;


@Setter
@Getter
public class CustomThreadPool {

    /**
     * 线程池
     */
    private ThreadPoolExecutor threadPoolExecutor;

    /**
     * 线程池前缀
     */
    private String threadNamePrefix;

    /**
     * 核心线程数
     */
    private Integer corePoolSize;

    /**
     * 最大线程数
     */
    private Integer maximumPoolSize;

    /**
     * 存活时间
     */
    private Long keepAliveTime;

    /**
     * 时间单位
     */
    private TimeUnit unit;

    /**
     * 阻塞队列
     */
    private BlockingQueue<Runnable> workQueue;

    public CustomThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, String threadNamePrefix) {

        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
        this.workQueue = workQueue;
        this.threadNamePrefix = threadNamePrefix;

        this.threadPoolExecutor = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.keepAliveTime, this.unit, this.workQueue, new CustomThreadFactory(this.threadNamePrefix), new ThreadPoolExecutor.CallerRunsPolicy());
        // 增加线程池监控
        // ThreadPoolExecutorMetricsRegister.registerAndWrap(this.threadNamePrefix, this.threadPoolExecutor);
    }

    /**
     * 清理线程池中所有的任务
     */
    public void clearAllTask() {

        // 等待其他线程运行完毕，在此期间不向该线程中添加任何任务
        // 关闭线程池，线程池，此刻已经不在接收新的任务，
        // this.threadPoolExecutor.shutdown();
        try {
            // 立即停止正在执行的任务，
            this.threadPoolExecutor.shutdown();
            while (!this.threadPoolExecutor.isTerminated()) {
                boolean isClearComplete = this.threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);
                System.out.println(isClearComplete);
                System.out.println("线程池清理完毕");


            }

            // 重新给我的线程池赋值
            threadPoolExecutor = new ThreadPoolExecutor(this.getCorePoolSize(), this.getMaximumPoolSize(), this.getKeepAliveTime(), this.unit, this.workQueue, new CustomThreadFactory(this.getThreadNamePrefix()), new ThreadPoolExecutor.CallerRunsPolicy());
            System.out.println("重新给线程池赋值");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


}
