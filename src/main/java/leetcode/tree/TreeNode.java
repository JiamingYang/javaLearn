package leetcode.tree;/**
 * Created by 13577 on 2020/6/1.
 */

/**
 * @ClassName TreeNode
 * @Description
 * @Author 杨家铭
 * @Date 2020/6/1 15:46
 **/
public class TreeNode {

    public TreeNode leftChild;
    public TreeNode rightChild;
    public int num;

    public TreeNode(int paramNum,TreeNode left,TreeNode right){
        num=paramNum;
        leftChild=left;
        rightChild=right;

    }
}
