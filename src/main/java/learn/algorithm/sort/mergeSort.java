package learn.algorithm.sort;

/**
 * Created by Administrator on 2020/3/31.
 */
public class mergeSort {
    public static void main(String[] args) {
        int[] mergeArray=new int[]{17,34,12,2,33,5,67,5,4,22};
        mergesort(mergeArray,0,mergeArray.length-1);
        for ( int a: mergeArray ) {
            System.out.print(a + " ");
        }

    }
   public static  void mergesort(int[] arr,int low,int high){
        if (low >= high){
            return;
        }

        int middle = low + (high - low) / 2;
        mergesort(arr,low,middle);
        mergesort(arr,middle+1,high);
        merge(arr,low,middle,high);

    }

   public static  void merge(int[] array,int low,int middle,int high){
        int[] helper=array.clone();

        int leftPoint=low;
        int rightPoint=middle+1;
        int current=low;
        while (current <= high){
            if (leftPoint > middle){
                array[current++]=helper[rightPoint++];
            }else if (rightPoint > high){
                array[current++]=helper[leftPoint++];
            }else if (helper[leftPoint] < helper[rightPoint]){
                array[current++]=helper[leftPoint++];
            }else {
                array[current++] = helper[rightPoint++];
            }
        }


    }
}
