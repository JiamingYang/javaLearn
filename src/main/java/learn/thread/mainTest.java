package learn.thread;

public class mainTest {
    public volatile int total=0;

    public static void main(String[] args)throws Exception{
        mainTest test1=new mainTest();
        long startTime=System.currentTimeMillis();
        Thread thread1=new Thread(){

            @Override
            public  void run() {
                for(int i=0;i<500;i++){
                    synchronized (test1){
                        test1.total+=1;
                        System.out.print("当前线程为："+this.getName()+"\n");
                    }
                }
               // System.out.print("当前总数："+test1.total);
            }
        };
        Thread thread2=new Thread(){
            @Override
            public void run() {
                for(int i=0;i<500;i++){
                    synchronized (test1){
                        test1.total+=1;
                        System.out.print("当前线程为："+this.getName()+"\n");
                    }
                }
               // System.out.print("当前总数："+test1.total);
            }
        };
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.print("当前总数："+test1.total);
        long endTime=System.currentTimeMillis();
        long totalTime=endTime-startTime;
        System.out.print("总共耗时："+totalTime);
    }
}
