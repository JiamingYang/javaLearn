package leetcode.recursionandbacktracking;/**
 * Created by 13577 on 2020/7/6.
 */

/**
 * @ClassName pro52
 * @Description
 * @Author 杨家铭
 * @Date 2020/7/6 22:04
 **/

/**
 *N皇后问题：如何将n个皇后摆放在n*n的棋盘上,且皇后之间不互相攻击
 * 给定一个n返回不同解法数量
 *
 * 思路：回溯算法
 */
public class pro52 {
    boolean check(int row, int col, int[] columns){
        for (int r=0; r < row; r++){
            if(columns[r] == col || row - r == Math.abs(columns[r] - col)){
                return false;
            }
        }
        return true;
    }

    int count;

    int totalQueen(int n){
        count = 0;
        backtracking(n, 0, new int[n]);
        return count;
    }

    void backtracking(int n,int row, int[] columns){
        if ( row == n ){
            count++;
            return ;
        }

        for (int col = 0;col < n; col++){
            columns[row] = col;
            if(check(row,col,columns)){
                backtracking(n,row+1,columns);
            }
            columns[row] = -1;
        }
    }
}
