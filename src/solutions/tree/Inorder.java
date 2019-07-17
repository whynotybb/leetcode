package solutions.tree;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(8);
        TreeNode node2=new TreeNode(6);
        TreeNode node3=new TreeNode(10);
        TreeNode node4=new TreeNode(5);
        TreeNode node5=new TreeNode(7);
        TreeNode node6=new TreeNode(9);
        TreeNode node7=new TreeNode(11);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;

        Inorder inorder=new Inorder();
        ArrayList<Integer> arr= inorder.inorderTraversal(node1);
        for (int a:arr)
            System.out.print(a+" ");
    }
    private ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (!stack.isEmpty()||node!=null){
            while (node!=null){
                stack.add(node);
                node=node.left;
            }
            if (!stack.isEmpty()){
                node= stack.pop();
                res.add(node.val);
                node=node.right;
            }
        }
        return res;
    }
}
