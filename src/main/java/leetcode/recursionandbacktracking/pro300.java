package leetcode.recursionandbacktracking;/**
 * Created by 13577 on 2020/7/6.
 */

/**
 * @ClassName pro300
 * @Description
 * @Author 杨家铭
 * @Date 2020/7/6 23:53
 **/
/**
 * 给定一个无序数组，求他最大上升子序列长度
 * 递归算法
 */
public class pro300 {
    static int max;
    public int findMaxSub(int[] nums,int n){
        if (n <= 1){
            return n;
        }

        int maxEndHere = 1, result = 0;

        for (int i = 0;i < n; i++){
            result = findMaxSub(nums,i);
            if((nums[i-1] < nums[n-1]) && (result + 1 >maxEndHere)){
                maxEndHere = result +1;
            }
        }
        if (max < maxEndHere){
            max = maxEndHere;
        }

        return maxEndHere;
    }

    public int LIS(int[] nums){
        max = 1;
        findMaxSub(nums,nums.length);
        return max;

    }
}
