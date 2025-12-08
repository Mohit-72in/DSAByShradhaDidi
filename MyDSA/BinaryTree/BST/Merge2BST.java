package MyDSA.BinaryTree.BST;
import java.util.*;
//
//        3               6
//    /       \       /       \
//1           4       2       7
public class Merge2BST {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(6);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(7);

        List<Integer> arr1 = inorder(root1);
        List<Integer> arr2 = inorder(root2);

        List<Integer> arr = mergeArr(arr1,arr2);
        TreeNode root = generateBST(arr,0,arr.size()-1);
        preorder(root);
    }
    private static TreeNode generateBST(List<Integer> arr, int left, int right) {
        if(left > right) return null;
        int mid = left +(right-left)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = generateBST(arr,left,mid-1);
        root.right = generateBST(arr,mid+1,right);
        return root;
    }
    private static List<Integer> mergeArr(List<Integer> arr1,List<Integer> arr2){
        int l1 = arr1.size();
        int l2 = arr2.size();
        List<Integer> arr = new ArrayList<>();
        int i = 0,j = 0;
        while(i<l1 && j < l2){
            if(arr1.get(i)>arr2.get(j)){
                arr.add(arr2.get(j));
                j++;
            }else{
                arr.add(arr1.get(i));
                i++;
            }
        }
        while(i < l1){
            arr.add(arr1.get(i++));
        }
        while(j < l2){
            arr.add(arr2.get(j++));
        }
        return arr;
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
