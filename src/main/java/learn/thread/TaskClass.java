package learn.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskClass implements Runnable {
    AtomicInteger acnt;
    CountDownLatch latch;
    public TaskClass(AtomicInteger a, CountDownLatch latch){
        this.acnt=a;
        this.latch=latch;
    }

    @Override
    public void run() {
        acnt.incrementAndGet();
        latch.countDown();
    }
}
