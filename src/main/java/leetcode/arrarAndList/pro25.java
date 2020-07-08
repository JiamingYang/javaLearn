package leetcode.arrarAndList;/**
 * Created by 13577 on 2020/5/31.
 */

/**
 * @ClassName pro25
 * @Description
 * @Author 杨家铭
 * @Date 2020/5/31 16:21
 * @Section k个一组翻转链表
 **/
public class pro25 {

    public static void main(String[] args) {

        int i=10;
        Node preNode=null;
        Node headNode=null;
        while (i>0){
            Node node=new Node();
            node.num=i;
            if(i==10){
                preNode=node;
                headNode=node;
            }else {
                preNode.next=node;
                preNode=node;
            }
            i--;
        }

        Node headNodeCopy=headNode;
        while (headNodeCopy!=null){
            System.out.print(" "+headNodeCopy.num+"  ");
            headNodeCopy=headNodeCopy.next;
        }
        System.out.print("\n=========================================\n");
        reverseListByK(headNode,3);


    }

    public static void reverseListByK(Node headNode,int k){
        Node prev=null;
        Node curr=headNode;
        Node nextNode=null;
        while (curr!=null) {
            for (int i=0;i<k;i++){
                if(curr!=null){
                    nextNode=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=nextNode;
                }
            }
            //此时prev指向头已翻转链表头部
            while (prev!=null){
                System.out.print(" "+prev.num+" ");
                prev=prev.next;
            }
        }



    }


}
