package leetcode.recursionandbacktracking;/**
 * Created by 13577 on 2020/7/6.
 */

/**
 * @ClassName pro247
 * @Description
 * @Author 杨家铭
 * @Date 2020/7/6 20:39
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 中心对称数是旋转180度后依旧相同的数
 * 思路：递归
 */
public class pro247 {

    List<String> helper(int currLong,int needLong){
        if(currLong < 0 ||needLong < 0 || currLong > needLong){
            //抛出异常
        }
        if(currLong == 0) return new ArrayList<String>(Arrays.asList(""));
        if(currLong == 1) return new ArrayList<String>(Arrays.asList("0","1","8"));

        List<String> list = helper(currLong-2,needLong);
        List<String> res=new ArrayList<String>();

        for (int i = 0; i < list.size(); i++){
            String s=list.get(i);
            if(currLong != needLong) res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
            res.add("8" + s + "8");

        }

        return res;
    }
}
