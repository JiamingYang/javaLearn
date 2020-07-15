package learn.algorithm.sort;

import java.lang.reflect.Array;

/**
 * Created by Administrator on 2020/3/29.
 */
public class bubble {

    //时间复杂度平均情况O（n^2） 空间复杂度O(1)
    public static void main(String[] args) {
        int tempIndex=0;
        int[] bubbleArray=new int[]{1,4,5,56,3,12,45,23,55,44};

        for(int i=0;i<bubbleArray.length-1;i++){
            for(int j=0;j<bubbleArray.length-i-1;j++){
                if(bubbleArray[j]>bubbleArray[j+1]){
                    tempIndex=bubbleArray[j];
                    bubbleArray[j]=bubbleArray[j+1];
                    bubbleArray[j+1]=tempIndex;
                }
            }
        }

        for ( int a:bubbleArray) {
            System.out.print(" "+a+" ");
        }
    }
}
