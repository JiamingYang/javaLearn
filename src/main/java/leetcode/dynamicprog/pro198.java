package leetcode.dynamicprog;/**
 * Created by 13577 on 2020/7/7.
 */

/**
 * @ClassName pro198
 * @Description
 * @Author 杨家铭
 * @Date 2020/7/7 0:21
 **/

/**
 * 打家劫舍：一排房屋，每家房屋放有一定金额。如果小偷在同一晚上闯入相邻的屋子，会触发警报。求小偷一晚能偷窃到最高金额
 * 递归公司：dp[i]=max(dp[i-1],dp[i-2]+nums[i])
 */
public class pro198 {

    public int rob(int[] nums){
        int n = nums.length;
        if( n == 0)return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for (int i = 2;i < n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[n-1];
    }
}
