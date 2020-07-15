package learn.algorithm.sort;/**
 * Created by 13577 on 2020/5/3.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**快速排序
 * @ClassName QuickSort
 * @Description
 * @Author 杨家铭
 * @Date 2020/5/3 11:28
 * @Section 公共服务产品部
 **/
public class QuickSort {

    public static void   sort(int[] array,int low,int high){
        if(low >= high){
            return ;
        }
        int p = partition(array,low,high);
        sort(array,low,p-1);
        sort(array,p+1,high);
    }
    public static int partition(int[] array,int low,int high ){
        int i,j;
        for ( i=low, j=low;j < array.length;j++){
            if (array[j] < array[high]){
                swap(array,j , i);
                i++;
            }
        }
        swap(array,i,high);
        return i;
    }

    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[20];
        Random random=new Random();
        for (int j=0;j<20;j++){
            nums[j]=random.nextInt(100);
        }

        for (int ele:nums){
            System.out.print(ele+" ");
        }

        System.out.println("\n================================================");
        sort(nums,0,nums.length-1);

        for (int ele:nums){
            System.out.print(ele+" ");
        }
    }
}
