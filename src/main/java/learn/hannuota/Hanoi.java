package learn.hannuota;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by 13577 on 2019/1/13.
 */
public class Hanoi {
    private static Stack stackA = new Stack();
    private static Stack stackB = new Stack();
    private static Stack stackC = new Stack();

    public static void resetHanoiTower(int n,Stack<Integer> A ,Stack<Integer> B , Stack<Integer> C){
        if(n==1){
            Integer temp = A.pop();
            C.push(temp);
            System.out.print("\n");
            System.out.print("A: " +stackA.toString()+" B: "+stackB.toString()+" C: "+stackC.toString());
            System.out.print("\n");
        }else{
            resetHanoiTower(n-1,A , C ,B);
            Integer bigTemp = A.pop();
            C.push(bigTemp);
            System.out.print("\n");
            System.out.print("A: " +stackA.toString()+" B: "+stackB.toString()+" C: "+stackC.toString());
            System.out.print("\n");
            resetHanoiTower(n-1,B,A,C);
        }

    }

    public static void main(String[] args) {
        int k = 20;
        for(int i = k;i>0; i--){
            stackA.push(new Integer(i));
        }
        System.out.print("\n");
        System.out.print("A: " +stackA.toString()+" B: "+stackB.toString()+" C: "+stackC.toString());
        System.out.print("\n");
        long startTime = System.currentTimeMillis();
        resetHanoiTower(k,stackA,stackB,stackC);
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.print("\n");
        System.out.print("total time :");
        System.out.print(totalTime);
    }
}
