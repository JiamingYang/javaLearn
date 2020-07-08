package leetcode.arrarAndList;/**
 * Created by 13577 on 2020/5/31.
 */

import java.util.ArrayList;

/**
 * @ClassName pro239
 * @Description
 * @Author 杨家铭
 * @Date 2020/5/31 22:55
 * @Section 求出这个数组中，滑动窗口内最大值
 **/
public class pro239 {
    public static void main(String[] args) {

        int[] sortArray=new int[]{1,3,-1,-3,5,3,6,7};
        int head=0,tail,max=0;
        tail=2;
        max=getMaxIndex(sortArray,0);

        while (tail<sortArray.length){
            if(tail>2) {
                if(head<=max){
                    if(sortArray[tail]>sortArray[max]){
                        max=tail;
                    }
                }else {
                    max=getMaxIndex(sortArray,head);
                }

            }
             System.out.print(" "+sortArray[max]+" ");
            head++;
            tail++;
        }

    }

    public static int getMaxIndex(int[] array,int head ){
        int a=array[head];
        int b=array[head+1];
        int c=array[head+2];
        if(a>b&&a>c){
            return head;
        }else if(b>a&&b>c){
            return head+1;
        }else {
            return head+2;
        }
    }
}
