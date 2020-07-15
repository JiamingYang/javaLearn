package learn.algorithm.sort;

/**
 * Created by Administrator on 2020/3/30.
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] bubbleArray=new int[]{1,4,5,56,3,12,45,23,55,44};
        for (int i=0;i<bubbleArray.length-1;i++){
            int tempIndex=0;

            for(int j=0;j<bubbleArray.length-i;j++){
                if (bubbleArray[tempIndex]<bubbleArray[j]){
                    tempIndex=j;
                }
            }
            int temp=bubbleArray[tempIndex];
            bubbleArray[tempIndex]=bubbleArray[bubbleArray.length-1-i];
            bubbleArray[bubbleArray.length-1-i]=temp;
        }

        for ( int a:bubbleArray) {
            System.out.println(" "+a+" ");
        }
    }
}
