package learn.thread;

import java.util.concurrent.*;

public class futureTaskTest {
    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(10,100,0, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10));
        Task task=new Task();

        Future<Integer> result=executorService.submit(task);
        executorService.shutdown();
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e1){
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.print("运行结果"+result.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException f){
            f.printStackTrace();
        }
        System.out.println("所有任务执行完毕");

    }


}
class Task implements Callable<Integer>{
    public Integer call() throws Exception{
        System.out.println("子线程在进行计算");

        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++){
            sum += i;
        }
        return sum;
    }
}