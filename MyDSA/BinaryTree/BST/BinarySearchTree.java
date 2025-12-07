package MyDSA.BinaryTree.BST;

import MyDSA.BinaryTree.SubTree;

import java.util.ArrayList;


public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7,11,13,6,9,8,12};
        Node root = null;
        for(int i = 0;i< values.length;i++){
            root = create(root,values[i]);
        }
        inorder(root);
        int key = 7;
        boolean isFound = search(root,key);
        if(isFound){
            System.out.println("\nFound");
        }else{
            System.out.println("\nNot Found");
        }
        int val = 5;
        root = deleteNode(root,val);
        inorder(root);
        System.out.println();
        int k1 = 6,k2 = 12;
        printInRange(root,k1,k2);
        System.out.println("\nAll Paths from root to leafs are :");
        printPathRootToLeaf(root, new ArrayList<>());
        System.out.println();
        if(isValidateBST(root,null,null)){
            System.out.println("Valid BST");
        }else{
            System.out.println("NOT VALID BST");
        }
        preorder(root);
        System.out.println();
        root = createMirrorImageBST(root);
        preorder(root);
    }

    private static Node createMirrorImageBST(Node root) {
        //base case if root == null return null
        if(root == null){
            return null;
        }
        Node leftSubtree = createMirrorImageBST(root.left);
        Node rightSubTree = createMirrorImageBST(root.right);
        //swap
        root.left = rightSubTree;
        root.right = leftSubtree;
        return root;
    }

    private static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    private static boolean isValidateBST(Node root, Node min, Node  max) {
        //Base CAse: root == null then null is consider as valid BST so return true
        if(root == null){
            return true;
        }
        // check root.data < minNode.data then it invalidate BST property
        if(min != null && root.data < min.data){
            return false;
        }
        // check root.data > maxNode.data then it invalidate BST property
        if(max != null && root.data > max.data){
            return false;
        }
        // if root follow all the property then time to check for its left and right subtree
        return isValidateBST(root.left,min,root) && isValidateBST(root.right,root,max);
    }

    private static void printPathRootToLeaf(Node root, ArrayList<Integer> path) {
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printPathRootToLeaf(root.left,path);
        printPathRootToLeaf(root.right,path);
        path.remove(path.size()-1);

    }

    private static void printPath(ArrayList<Integer> path) {
        for(int x : path){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    private static void printInRange(Node root, int k1, int k2) {
        //base case
        if(root == null){
            return;
        }
        // case 1: if root.data lie bt k1 & k2 , traverse both left subtree and right subtree
        if(root.data>= k1 && root.data <= k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right,k1,k2);
        }
        // case 2 : if root.data > k2 , all value of range lie in left subtree of root
        if(root.data> k2){
            printInRange(root.left,k1,k2);
        } // root.data <= k1 then all values must lie on right subtree of root
        else if(root.data < k1){
            printInRange(root.right,k1,k2);
        }
    }

    private static Node deleteNode(Node root, int val) {

        if(root.data < val){
            root.right =  deleteNode(root.right,val);
        }else if(root.data > val){
            root.left =  deleteNode(root.left,val);
        }else{
            //case 1 if delelte node is child node
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2 : if deleted node is either on left child or right chile
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                //case 3 when delete a node which has both left and right child
                Node IS = findInOrderSuccessor(root.right);
                root.data = IS.data;
                root.right = deleteNode(root.right, IS.data);
            }
        }
        return root;

    }

    private static Node findInOrderSuccessor(Node root) {
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    private static Node create(Node root,int val){
        // if root = null add newNode and mark as root
        if(root == null){
            root = new Node(val);
            return root;
        }
        //if root.data > val --> insert at left of root
        if(root.data > val){
            root.left = create(root.left,val);
        }else if(root.data < val){
            //if root.data < val --> insert at right of root
            root.right = create(root.right,val);
        }
        return root;
    }

    private static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    private static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        } else if (root.data > key) {
            return search(root.left,key);
        }else  {
            return search(root.right, key);
        }
    }
}
