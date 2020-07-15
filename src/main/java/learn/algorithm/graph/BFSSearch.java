package learn.algorithm.graph;/**
 * Created by 13577 on 2020/5/3.
 */

import java.util.ArrayList;

/**
 * @ClassName BFSSearch
 * @Description
 * @Author 杨家铭
 * @Date 2020/5/3 15:27
 * @Section 公共服务产品部
 **/
public class BFSSearch {
    public boolean isCheck=false;

    public boolean isFruit;

    public String name;


    public ArrayList<BFSSearch> neighborArray=new ArrayList<>();

    public BFSSearch(String name){
        this.name=name;
    }
}
