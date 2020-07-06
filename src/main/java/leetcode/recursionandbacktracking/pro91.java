package leetcode.recursionandbacktracking;/**
 * Created by 13577 on 2020/7/6.
 */

/**
 * @ClassName pro91
 * @Description
 * @Author 杨家铭
 * @Date 2020/7/6 20:15
 **/

/**
 * 一条字母按以下顺序编码  A->1 B->2 ...Z->26。给一串数字，求包含多少解码可能性
 */
public class pro91 {

    int numDecoding(String s){
        char[] chars=s.toCharArray();
        return decodeChars(chars,chars.length-1);
    }

    int decodeChars(char[] chars,int index){
        if(index<=0){
            return 1;
        }
        int count = 0;
        char curr=chars[index];
        char prev=chars[index-1];

        if( curr > '0'){
            count=decodeChars(chars,index-1);
        }
        if(prev == '1' || ( prev == '2' && curr <= '6')){
            count+=decodeChars(chars,index-2);
        }
        return count;
    }
}
