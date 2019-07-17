package solutions.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrder {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        node1.left=new TreeNode(2);
        PreOrder preOrder=new PreOrder();
        ArrayList<Integer> res= preOrder.preorderTraversal(node1);
       for (Integer er:res){
           System.out.print(er+" ");
       }
    }
    private ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (!stack.isEmpty()||node!=null){
           while (node!=null){
                stack.add(node);
                res.add(node.val);
                node=node.left;
            }
            if (!stack.isEmpty()){
                node= stack.pop();
                node=node.right;
            }
        }
        return res;
    }
}
