package leetcode.dynamicprog;/**
 * Created by 13577 on 2020/7/6.
 */

/**
 * @ClassName pro300
 * @Description
 * @Author 杨家铭
 * @Date 2020/7/6 23:38
 **/

import java.util.HashMap;

/**
 * 给定一个无序数组，求他最大上升子序列长度
 *
 * 动态规划解法
 */
public class pro300 {

    static int max;
    static HashMap<Integer,Integer> cache;
    public int findMaxSub(int[] nums,int n){
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        if (n <= 1){
            return n;
        }

        int maxEndHere = 1, result = 0;

        for (int i = 1;i < n; i++){
            result = findMaxSub(nums,i);
            if((nums[i-1] < nums[n-1]) && (result + 1 >maxEndHere)){
                maxEndHere = result +1;
            }
        }
        if (max < maxEndHere){
            max = maxEndHere;
        }
        cache.put(n,maxEndHere);

        return maxEndHere;
    }

    public int LIS(int[] nums){
        max = 1;
        findMaxSub(nums,nums.length);
        return max;

    }

    /**
     * 另一种动态规划解法
     * @param nums
     * @param n
     * @return
     */
    public int LISPOP(int[] nums , int n){
        int[] cache = new int[n];
        int max = 0;

        for (int i = 0;i < n; i++)cache[i]=1;

        for (int i = 1;i < n; i++){
            for (int j = 0; j< i;j++){
                if(nums[j]<nums[i]&&cache[i]<cache[j]+1){
                    cache[i]=cache[j]+1;
                }
            }
            max=Math.max(max,cache[i]);
        }

        return max;


    }
}
