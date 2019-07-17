package solutions.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class PostOrder {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        node1.left=node2;
        PostOrder postOrder=new PostOrder();
        ArrayList<Integer> res= postOrder.postorderTraversal(node1);
        for (Integer er:res){
            System.out.print(er+" ");
        }
    }
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        Set<TreeNode> visited=new HashSet<>();
        stack.add(root);
        visited.add(root);
        while (!stack.isEmpty()){
             TreeNode node= getNextNode(stack.peek(),visited);
            if (node==null){
                res.add(stack.pop().val);
            }else {
                stack.add(node);
                visited.add(node);
            }
        }
        return res;
    }
    private TreeNode getNextNode(TreeNode node,Set<TreeNode> visited){
        if (node.left!=null&&!visited.contains(node.left)){
            return node.left;
        }
        if (node.right!=null&&!visited.contains(node.right)){
            return node.right;
        }
        return null;
    }
}
