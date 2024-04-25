package cc.blog.alex.threaddemo.threadpool;

import java.util.concurrent.*;

/**
 * 文件IO专用：上传、下载需区分为两个独立的线程池
 * 使用{@link IOThreadPoolExecutorWrapper}封装
 * 参考{@link com.xiaomi.virtual.threadpool.IOThreadPoolExecutorWrapperTest}
 *  todo：使用{@link MdcExecutors}封装
 *
 * @author wuhongbin@xiaomi.com
 * @date 2024/4/18 17:53
 */
public class IOThreadPoolExecutor extends ThreadPoolExecutor {

    /**
     * 标识线程池刚初始化状态，只要添加任务就为false
     */
    private volatile boolean brandNew;

    public IOThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {

        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.brandNew = true;
    }

    public IOThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {

        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        this.brandNew = true;
    }

    public IOThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {

        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
        this.brandNew = true;
    }

    public IOThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {

        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        this.brandNew = true;
    }

    public boolean isBrandNew() {

        return brandNew;
    }

    @Override
    protected void terminated() {

        // log.warn("线程池[{}]已完全关闭", this);
        System.out.println("线程池[{}]已完全关闭"+this);
        super.terminated();
    }

    @Override
    public void execute(Runnable command) {

        if (brandNew) {
            brandNew = false;
        }
        super.execute(command);
    }



}
