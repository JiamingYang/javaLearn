package leetcode.binarysearch;/**
 * Created by 13577 on 2020/7/7.
 */

/**
 * @ClassName pro34
 * @Description
 * @Author 杨家铭
 * @Date 2020/7/7 11:26
 **/

/**
 * 给定一个排好序的升序nums,和一个目标值target,找出给定目标值在数组中的起始位置和终止位置
 */
public class pro34 {
    /**
     * 查找上边界
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    int searchUpDown(int[] nums,int target,int low,int high){
        if (low > high){
            return -1;
        }
        int middle = low + (high - low)/2;

        if (nums[middle] == target&&(middle == nums.length-1||nums[middle+1] > target)){
            return middle;
        }

        if (target < nums[middle]){
            return searchUpDown(nums,target,low,middle-1);
        }else {
            return searchUpDown(nums,target,middle+1,high);
        }

    }
    /**
     * 查找下边界
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    int searchLowDown(int[] nums,int target,int low,int high){
        if (low > high){
            return -1;
        }
        int middle = low + (high - low)/2;

        if (nums[middle] == target&&(middle == 0||nums[middle-1] < target)){
            return middle;
        }

        if (target < nums[middle]){
            return searchUpDown(nums,target,low,middle-1);
        }else {
            return searchUpDown(nums,target,middle+1,high);
        }

    }
}
