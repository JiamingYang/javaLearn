package leetcode.tree;


import java.util.ArrayList;
import java.util.Stack;

public class pro230 {
    public volatile static   Integer k=3;

    public static void main(String[] args) {
        TreeNode leaf=new TreeNode(1,null,null);
        TreeNode secNode=new TreeNode(2,leaf,null);
        TreeNode node4=new TreeNode(4,null,null);
        TreeNode node3=new TreeNode(3,secNode,node4);
        TreeNode node6=new TreeNode(6,null,null);
        TreeNode node5=new TreeNode(5,node3,node6);

        postorderTraversal(node5);

    }

    public static void getKminByRecur(TreeNode root){
        if(root.rightChild==null&&root.leftChild==null){
            k--;
            if(k.intValue()==0){
                System.out.print("  "+root.num+" ");
            }
        }else {
            getKminByRecur(root.leftChild);
            k--;
            if(k.intValue()==0){
                System.out.print("  "+root.num+" ");
            }
            if(root.rightChild!=null){
                getKminByRecur(root.rightChild);
            }
        }
    }

    /**
     * 用栈进行中序遍历
     * @param node
     */
    public static void getKminByStack(TreeNode node){
        Stack<TreeNode> calStack=new Stack<TreeNode>();
        boolean toLeafFlag=false;
        ArrayList arrayList=new ArrayList();

        TreeNode parentNode=node;
        while (calStack.size()>0||parentNode!=null){
            while (parentNode!=null){
                calStack.push(parentNode);
                parentNode=parentNode.leftChild;
            }
            parentNode=calStack.pop();
            arrayList.add(parentNode.num);
            parentNode=parentNode.rightChild;
        }

        System.out.print("  "+arrayList.get(k-1)+" ");
    }
    /**
     *前序遍历
     */
    public static void preTraversal(TreeNode root){
        Stack<TreeNode> treeStack=new Stack<TreeNode>();
        treeStack.push(root);
        while (treeStack.size()>0){
            TreeNode parentNode=treeStack.pop();
            while (parentNode!=null){
                System.out.print(parentNode.num);
                if(parentNode.rightChild!=null){//后处理的先压入栈中，先处理的赋值给parentNode进入到下一个循环
                    treeStack.push(parentNode.rightChild);
                }
                parentNode=parentNode.leftChild;
            }
        }
    }

    /**
     * 后续遍历
     * @param root
     */

    public static void postorderTraversal(TreeNode root){
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        TreeNode head = root;
        s1.push(head);
        while (s1.size()>0){
            head = s1.pop();
            s2.push(head);
            if (head.leftChild!=null){
                s1.push(head.leftChild);
            }
            if (head.rightChild != null){
                s1.push(head.rightChild);
            }
        }
        while (!s2.isEmpty()){
            System.out.print(s2.pop().num + " ");

        }


    }

}
