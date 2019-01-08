package learn.thread;

public class runnableTest implements Runnable {
    private int a,b;
    public runnableTest(int num1,int num2){
        this.a=num1;
        this.b=num2;
    }
    @Override
    public void run() {
        int t=add(a,b);
        System.out.print(t);
    }
    private int add(int a,int b){
        return a+b;
    }
}
