package com.wy.study.tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class ErChaShu {

    class TreeNode{
        int val;
        //左孩子
        TreeNode left;
        //右孩子
        TreeNode right;
    }

    public int maxDeath(TreeNode root) {
        return root==null?0:(Math.max(maxDeath(root.left),maxDeath(root.right))+1);
    }

    int getMinDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return getMin(root);
    }
    int getMin(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null&&root.right == null){
            return 1;
        }
        return Math.min(getMin(root.left),getMin(root.right)) + 1;
    }

    int numOfTreeNode(TreeNode root){
        return root==null?0:(numOfTreeNode(root.left)+numOfTreeNode(root.right)+1);
    }

    int numsOfNoChildNode(TreeNode root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null){
            return 1;
        }
        return numOfTreeNode(root.left)+numOfTreeNode(root.right);
    }

    int numsOfkLevelTreeNode(TreeNode root ,int k){
        if(root==null||k<1){
            return 0;
        }
        if(k==1){
            return 1;
        }

        return numsOfkLevelTreeNode(root.left,k-1)+numsOfkLevelTreeNode(root.right,k-1);
    }

    boolean isBalanced(TreeNode root){
        return maxDepth2(root)!=-1;

    }

    int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    boolean isCompleteTreeNode(TreeNode root){
        if(root==null) return false;
        Queue<TreeNode> queen = new LinkedList<TreeNode>();
        queen.add(root);
        boolean result = true;
        boolean hasNoChild = false;
        while (!queen.isEmpty()) {
            TreeNode node = queen.remove();
            if (hasNoChild) {
                if (node.left != null || node.right != null) {
                    return false;
                }
            } else {
                if(node.left!=null&&node.right!=null){
                    queen.add(root.left);
                    queen.add(root.right);
                    hasNoChild = false;
                }else if(node.left!=null&&node.right==null){
                    queen.add(root.left);
                    hasNoChild = true;
                } else if (node.left == null && node.right != null) {
                    return false;
                }else{
                    hasNoChild = true;
                }
            }
        }

        return result;
    }

    boolean isSameTreeNode(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }

        return isSameTreeNode(t1.left,t2.left)&&isSameTreeNode(t1.right,t2.right);
    }

    boolean isMirror(TreeNode t1,TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }

    TreeNode mirrorTreeNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTreeNode(root.left);
        TreeNode right = mirrorTreeNode(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
