package cc.blog.alex;

import java.io.Console;
import java.lang.reflect.Field;
import java.text.Format;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Alex
 * @since 2024/5/22 上午10:34
 * <p></p>
 */
public class SemaphoreTest {

    public static Integer THREAD_COUNT = 10;

    public static Executor executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {

        ////模拟100辆车进入停车场
        // for(int i=0;i<100;i++){
        //     Thread thread=new Thread(new Runnable() {
        //         public void run() {
        //             try {
        //                 System.out.println("===="+Thread.currentThread().getName()+"来到停车场");
        //                 if(semaphore.availablePermits()==0){
        //                     System.out.println("车位不足，请耐心等待");
        //                 }
        //                 semaphore.acquire();//获取令牌尝试进入停车场
        //                 System.out.println(Thread.currentThread().getName()+"成功进入停车场");
        //                 Thread.sleep(new Random().nextInt(10000));//模拟车辆在停车场停留的时间
        //                 System.out.println(Thread.currentThread().getName()+"驶出停车场");
        //                 semaphore.release();//释放令牌，腾出停车场车位
        //             } catch (InterruptedException e) {
        //                 e.printStackTrace();
        //             }
        //         }
        //     },i+"号车");
        //
        //     thread.start();
        //
        // }

        System.out.println("-------------");
        System.err.println("=====GC=====");

    }

}
