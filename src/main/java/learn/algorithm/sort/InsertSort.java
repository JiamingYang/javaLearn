package learn.algorithm.sort;

/**
 * Created by Administrator on 2020/3/31.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] bubbleArray=new int[]{7,4,5,56,3,12,45,23,55,44};
        int count =0;
        for(int i=1,j;i<bubbleArray.length;i++){
            int temp=bubbleArray[i];
            j=i;
            while (j>=1&&temp<bubbleArray[j-1]){
                bubbleArray[j]=bubbleArray[j-1];
                j--;
            }
            bubbleArray[j]=temp;
        }

        for ( int a:bubbleArray) {
            System.out.print(" "+a+" ");
        }


    }
}
