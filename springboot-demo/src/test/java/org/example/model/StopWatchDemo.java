package org.example.model;

import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author Alex
 * @since 2024/6/3 上午11:03
 * <p></p>
 */
public class StopWatchDemo {

    @Test
    public void stopWatchDemo() {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("task1");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        stopWatch.stop();
        stopWatch.start("task2");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        //System.out.println(stopWatch.getLastTaskName()); // 最后一个任务的名称
        //System.out.println(stopWatch.currentTaskName()); // 当前任务名称
        //System.out.println(stopWatch.getTaskCount()); // 任务数量
        //System.out.println(stopWatch.getTotalTimeMillis()); // 获取任务总共的毫秒
        //System.out.println(stopWatch.getLastTaskTimeNanos()); // 获取任务总共执行的纳秒
        //System.out.println(stopWatch.getTotalTimeSeconds()); // 获取秒


    }

}
