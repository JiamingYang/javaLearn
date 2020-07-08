package leetcode.arrarAndList;/**
 * Created by 13577 on 2020/5/31.
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName pro739
 * @Description
 * @Author 杨家铭
 * @Date 2020/5/31 17:20
 * @Section 给一组气温序列，生成新的序列，新序列每个位置上的值是旧序列中温度超过当前温度所需要的天数
 **/
public class pro739 {

    public static void main(String[] args) {
        TempAndDayNum data1=new TempAndDayNum(23,0);
        TempAndDayNum data2=new TempAndDayNum(24,1);
        TempAndDayNum data3=new TempAndDayNum(25,2);
        TempAndDayNum data4=new TempAndDayNum(21,3);
        TempAndDayNum data5=new TempAndDayNum(19,4);
        TempAndDayNum data6=new TempAndDayNum(22,5);
        TempAndDayNum data7=new TempAndDayNum(26,6);
        TempAndDayNum data8=new TempAndDayNum(23,7);

        Stack<TempAndDayNum> tempList=new Stack<TempAndDayNum>();
        tempList.push(data8);
        tempList.push(data7);
        tempList.push(data6);
        tempList.push(data5);
        tempList.push(data4);
        tempList.push(data3);
        tempList.push(data2);
        tempList.push(data1);

        Stack<TempAndDayNum> calCantain=new Stack<TempAndDayNum>();
        int[] newList=new int[8];
        while (tempList.size()>0){
            TempAndDayNum newTemp=tempList.pop();
            if(calCantain.size()==0){
                calCantain.push(newTemp);
            }else {
                TempAndDayNum oldTemp=calCantain.peek();
                if (oldTemp.temp<newTemp.temp){
                    while (calCantain.size()>0&&(oldTemp.temp<newTemp.temp)){
                        newList[oldTemp.day]=newTemp.day-oldTemp.day;
                        calCantain.pop();
                        if(calCantain.size()>0){
                            oldTemp=calCantain.peek();
                        }else {
                            break;
                        }

                    }
                    calCantain.push(newTemp);

                }else {
                    calCantain.push(newTemp);
                }
            }
        }
        for (TempAndDayNum temp:calCantain) {
            newList[temp.day]=0;
        }


        for (Integer num:newList) {
            System.out.print(" "+num+" ");

        }



    }
}
