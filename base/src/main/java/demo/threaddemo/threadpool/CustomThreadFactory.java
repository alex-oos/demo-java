package src.main.java.demo.threaddemo.threadpool;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadFactory;

@Setter
@Getter
public class CustomThreadFactory implements ThreadFactory {

    private String threadNamePrefix;

    public CustomThreadFactory(String threadNamePrefix) {

        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {

        Thread thread = new Thread(r);
        thread.setName(threadNamePrefix + "-" + thread.getId()); // 设置线程名称
        return thread;
    }

}
