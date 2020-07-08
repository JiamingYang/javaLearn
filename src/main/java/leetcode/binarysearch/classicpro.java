package leetcode.binarysearch;/**
 * Created by 13577 on 2020/7/7.
 */

/**
 * @ClassName classicpro
 * @Description
 * @Author 杨家铭
 * @Date 2020/7/7 10:51
 **/

/**
 * 经典二分查找算法
 */
public class classicpro {

    /**
     * 递归算法
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    int binarySearch(int[] nums,int target,int low,int high){
        if (low > high){
            return -1;
        }
        int middle = low + (high - low)/2;//不能简单用(low+high)/2，会导致溢出

        if(nums[middle] == target){
            return middle;
        }
        if(nums[middle] < target){
            return binarySearch(nums,target,middle+1,high);
        }else {
            return binarySearch(nums,target,low,middle-1);
        }
    }

    int nonBinarySearch(int[] nums,int target,int low,int high){
        while (low <= high){
            int middle = low + (high - low)/2;
            if(nums[middle] == target){
                return middle;
            }
            if(nums[middle] < target){
                low = middle + 1;
            }else {
                high = middle - 1;
            }

        }
        return -1;
    }
}
