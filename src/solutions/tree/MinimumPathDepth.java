package solutions.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary tree, find its minimum depth.The minimum depth is the number of nodes
 * along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumPathDepth {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(1);
        TreeNode node4=new TreeNode(1);
        TreeNode node5=new TreeNode(1);
        TreeNode node6=new TreeNode(1);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node6;

        MinimumPathDepth minimumPathDepth=new MinimumPathDepth();
        minimumPathDepth.run(node1);
    }
    private int run(TreeNode root){
        if (root==null){
            return 0;
        }
        if (isLeafNode(root)){
            return 1;
        }
        int minDepth=Integer.MAX_VALUE;
        ArrayList<TreeNode> stack=new ArrayList<>();
        stack.add(root);
        Set<TreeNode> visited=new HashSet<>();
        visited.add(root);
        while (!stack.isEmpty()){
            TreeNode node = getNextNode(stack.get(stack.size()-1),visited);
            if (node==null){
                stack.remove(stack.size()-1);
            }else {
                visited.add(node);
                stack.add(node);
                if (isLeafNode(node)){
                     int depth=stack.size();
                     minDepth= minDepth>depth?depth:minDepth;
                }
            }
        }
        return minDepth;
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
    private boolean isLeafNode(TreeNode node){
        return node.left==null&&node.right==null;
    }
}
