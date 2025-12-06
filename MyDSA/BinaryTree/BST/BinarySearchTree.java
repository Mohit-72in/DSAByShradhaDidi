package MyDSA.BinaryTree.BST;

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
