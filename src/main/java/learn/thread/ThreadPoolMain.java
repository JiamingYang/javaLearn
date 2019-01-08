package learn.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolMain {
    public static void main(String[] args) {

        AtomicInteger total=new AtomicInteger(0);
        CountDownLatch latch=new CountDownLatch(1000);
        ThreadPoolExecutor executor=new ThreadPoolExecutor(10,100,0, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10));

        TaskClass task=new TaskClass(total,latch);
        long startTime=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            executor.execute(task);
        }
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        executor.shutdown();
        long totalTime=System.currentTimeMillis()-startTime;
        System.out.print(total.get());
        System.out.print("当前程序耗时"+totalTime);
    }
}
