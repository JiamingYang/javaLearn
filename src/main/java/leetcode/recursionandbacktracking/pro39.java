package leetcode.recursionandbacktracking;/**
 * Created by 13577 on 2020/7/6.
 */

/**
 * @ClassName pro39
 * @Description
 * @Author 杨家铭
 * @Date 2020/7/6 21:35
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个无重复元素数组candidates 和目标target，找出candidates中所有和为target的组合
 *
 * candidates的所有元素可以无限选择
 * 解集不能包含重复组合
 */
public class pro39 {

    ArrayList<Stack> combinationSum(int[] candidates,int target){
        ArrayList<Stack> results = new ArrayList<Stack>();
        Stack solution = new Stack();
        backtracking(candidates,target,0,solution,results);
        return results;
    }
    void backtracking(int[] candidates,int target,
    int start,Stack solution,ArrayList<Stack> results){
        if( target < 0){
            return;

        }

        if (target == 0){
            results.add(solution);
        }else {
            for (int i = start; i<candidates.length; i++){
                solution.push( candidates[i] );
                backtracking(candidates,target - candidates[i],i,solution,results);
                solution.pop();
            }
        }

    }
}
