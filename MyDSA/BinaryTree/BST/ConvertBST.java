package MyDSA.BinaryTree.BST;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertBST {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(11);
        root.right.right.right = new TreeNode(12);


        List<Integer> arr = inorder(root);
        TreeNode node = GenerateBalancedBT( arr,0,arr.size()-1);
        preorder(node);
    }

    private static TreeNode GenerateBalancedBT(List<Integer> arr,int left,int right) {
        if(left > right) return null;
        int mid = left +(right-left)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = GenerateBalancedBT(arr,left,mid-1);
        root.right = GenerateBalancedBT(arr,mid+1,right);
        return root;
    }
    private static TreeNode buildTree(TreeNode root,int val){
        if(root == null){
            root = new TreeNode(val);
        }
        if(root.val < val){
            root.right = buildTree(root.right,val);
        }else{
            root.left = buildTree(root.left,val);
        }
        return root;
    }

    private static List<Integer> inorder(TreeNode root){
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        if(root.left != null)
            arr.addAll(inorder(root.left));
        arr.add(root.val);
        if(root.right  != null)
            arr.addAll(inorder(root.right));
        return arr;
    }
    public static void preorder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
}
