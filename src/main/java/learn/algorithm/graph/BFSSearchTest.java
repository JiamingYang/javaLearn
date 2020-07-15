package learn.algorithm.graph;/**
 * Created by 13577 on 2020/5/3.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BFSSearchTest
 * @Description
 * @Author 杨家铭
 * @Date 2020/5/3 15:34
 * @Section 公共服务产品部
 **/
public class BFSSearchTest {
    public static void main(String[] args) {

        BFSSearch me=new BFSSearch("me");
        BFSSearch alice=new BFSSearch("alice");
        BFSSearch bob=new BFSSearch("bob");
        BFSSearch anuj=new BFSSearch("anuj");
        BFSSearch claire=new BFSSearch("claire");
        BFSSearch thom=new BFSSearch("thom");
        BFSSearch jonny=new BFSSearch("jonny");
        BFSSearch peggy=new BFSSearch("peggy");


        anuj.isFruit=true;
        me.neighborArray.add(bob);
        me.neighborArray.add(claire);
        me.neighborArray.add(alice);

        claire.neighborArray.add(thom);
        claire.neighborArray.add(jonny);
        alice.neighborArray.add(peggy);
        bob.neighborArray.add(anuj);
        bob.neighborArray.add(peggy);


        Queue<BFSSearch> queue=new LinkedList<BFSSearch>();

        queue.add(me);
        while (queue.peek()!=null){
            BFSSearch headBode=queue.poll();
            if(headBode.isFruit==true){
                System.out.println("=====zhaodao:"+headBode.name+"=========");
                break;
            }else {
                ArrayList<BFSSearch> childlist=headBode.neighborArray;
                for (BFSSearch ele:childlist) {
                    queue.add(ele);
                }
            }
        }
    }
}
