package MyDSA.BinaryTree.BST;


import java.util.ArrayList;

public class BSTPractice2 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    static int count = 0;


    public static void main(String[] args) {
        int[] values = {8,4,6,5,7,10,9,12,11};
        Node root = null;
        for(int i = 0;i< values.length;i++){
            root = createBST(root,values[i]);
        }
        inorder(root);
        System.out.println();


        // search a key in BST
        int key = 3;
        if(search(root,key)){
            System.out.println("Key "+key+ " is Found");
        }else{
            System.out.println("key "+key+" is not found");
        }
        int k1 = 4,k2 = 7;
        System.out.println("Between "+k1+" And "+k2+" these no exist: ");
        printInRangeBST(root,k1,k2);
        int ke= 10;
        System.out.println("\nDekete key: "+ke+" from BST");
        root = deleteFromBST(root,ke);
        inorder(root);
        System.out.println("\nFrom root to leaf all paths are :");
        printPathRoot2Leaf(root,new ArrayList<>());

    }

    private static void printPathRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            count++;
            System.out.println("\nPath No "+count+" is:");
            printPath(path);
        }
        printPathRoot2Leaf(root.left,path);
        printPathRoot2Leaf(root.right,path);
        path.remove(path.size()-1);
    }
    private static void printPath(ArrayList<Integer> path){
        for(int x : path){
            System.out.print(x+" ");
        }
    }

    private static Node deleteFromBST(Node root, int key) {
        if(root.data < key){
            root.right = deleteFromBST(root.right,key);
        }else if(root.data > key){
            root.left = deleteFromBST(root.left,key);
        }else{
            //case 1 : delete leaf node
            if(root.left == null && root.right == null){
                return null;
            }  // if deleted node is either left or right child
            else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            } // if deleted node has both children then find INOrderSuccesor and replace with inOrderSuccessor
            else{
                Node IS = findInOrderSuccessor(root.right);
                root.data = IS.data;
                root.right = deleteFromBST(root.right,IS.data);
            }
        }
        return root;
    }
    private static Node findInOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    private static void printInRangeBST(Node root, int k1, int k2) {
        if(root == null ){
            return ;
        }
        // search on both side of the tree
        if(root.data >= k1 && root.data <= k2){
            printInRangeBST(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRangeBST(root.right,k1,k2);
        }
        //search only on right subtree
        else if(root.data < k1){
            printInRangeBST(root.right,k1,k2);
        }else{ // search only on left subtree
            printInRangeBST(root.left,k1,k2);
        }
    }

    private static void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    private static boolean search(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }else if(root.data < key){
            return search(root.right,key);
        }else{
            return search(root.left,key);
        }
    }

    private static Node createBST(Node root, int value) {
        if(root == null){
            root = new Node(value);
            return root;
        }else{
            if(root.data < value){
                root.right = createBST(root.right,value);
            }else{
                root.left = createBST(root.left,value);
            }
        }
        return root;
    }

}
