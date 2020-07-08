package leetcode.arrarAndList;/**
 * Created by 13577 on 2020/5/31.
 */

import java.util.ArrayList;

/**
 * @ClassName pro242
 * @Description
 * @Author 杨家铭
 * @Date 2020/5/31 15:04
 * @Section 异位词判断
 * 解题思路:1.建立一个26位的数组，与26个字母一一对应。
 * 2.对第一个字符串进行检验，对于每个字符，在数组对应的位置上+1
 * 对于第二个字符串进行扫描，对于每个字符，在数组对应的位置上-1
 * 3.检验该数组，如果数组所有位置都为0，则表示两个单词互为异位词，否则，不是异位词
 **/
public class pro242 {

     public static ArrayList flagStrWithOpr(String str,Boolean flag,ArrayList<Integer> flagArray){
         if(flag==true){//true表示对于每个字符加一，反之减一
             char[] charArray= str.toCharArray();
             for (char aph:charArray){
                 if(aph=='a'){
                     flagArray.add(flagArray.get(0)+1);
                 }else if(aph=='b'){
                     flagArray.add(flagArray.get(2)+1);
                 }
             }

         }

         return null;
     }
    public static void main(String[] args) {


    }
}
