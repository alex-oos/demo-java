package cc.blog.alex.threaddemo.threadpool;

import lombok.Getter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 文件IO专用：上传、下载需区分为两个独立的线程池
 * 当线程池执行任务时，如果有任何线程执行任务异常，则会立即停止线程池，并重新创建新的线程池
 *
 * @author wuhongbin@xiaomi.com
 * @date 2024/4/18 17:53
 */
@Getter
public class IOThreadPoolExecutorWrapper {

    /**
     * 实际工作的线程池
     */
    private volatile IOThreadPoolExecutor threadPoolExecutor;

    /**
     * 线程池清理锁
     */
    private final Object lock = new Object();

    /**
     * 线程池重置次数
     */
    private volatile AtomicInteger clearCount = new AtomicInteger(0);

    /**
     * 线程池前缀
     */
    private volatile String threadNamePrefix;

    /**
     * 核心线程数
     */
    private volatile Integer corePoolSize;

    /**
     * 最大线程数
     */
    private volatile Integer maximumPoolSize;

    /**
     * 存活时间
     */
    private volatile Long keepAliveTime;

    /**
     * 时间单位
     */
    private volatile TimeUnit unit;

    /**
     * 阻塞队列
     */
    private volatile BlockingQueue<Runnable> workQueue;

    public IOThreadPoolExecutorWrapper(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, String threadNamePrefix) {

        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
        this.workQueue = workQueue;
        this.threadNamePrefix = threadNamePrefix;
        this.threadPoolExecutor = new IOThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                new CustomThreadFactory(this.threadNamePrefix), new ThreadPoolExecutor.CallerRunsPolicy());
        this.threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /**
     * 清空线程池任务：供异常时中断文件IO场景
     */
    public void clear() {

        if (!this.threadPoolExecutor.isBrandNew()) {
            synchronized (lock) {
                if (!this.threadPoolExecutor.isBrandNew()) {
                    this.threadPoolExecutor.shutdownNow();
                    try {
                        boolean termination = this.threadPoolExecutor.awaitTermination(threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS) * 2, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    this.threadPoolExecutor = new IOThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                            new CustomThreadFactory(this.threadNamePrefix), new ThreadPoolExecutor.CallerRunsPolicy());
                    // log.warn("当前线程池[{}]已被重置，项目启动至今已重置：{}次", this.threadPoolExecutor, clearCount.incrementAndGet());
                    System.out.println("当前线程池[{}]已被重置，项目启动至今已重置：{}次" + this.threadPoolExecutor + clearCount.incrementAndGet());
                }
            }
        }
    }

}
