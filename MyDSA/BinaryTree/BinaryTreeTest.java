package MyDSA.BinaryTree;

public class BinaryTreeTest {

    // ---------- Node Class ----------
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // ---------- BinaryTree Class ----------
    static class BinaryTree {
        private int idx = -1;

        // Builds a binary tree from preorder list (using -1 as null marker)
        public Node buildTree(int[] values) {
            idx++;
            if (idx >= values.length || values[idx] == -1) {
                return null;
            }

            Node root = new Node(values[idx]);
            root.left = buildTree(values);
            root.right = buildTree(values);

            return root;
        }

        // Returns true if entire tree is uni-valued
        public boolean isUnivalTree(Node root) {
            if (root == null) return true;
            return checkUnival(root, root.data);
        }

        // Helper: checks if all nodes match the target value
        private boolean checkUnival(Node root, int value) {
            if (root == null) return true;

            if (root.data != value) return false;

            return checkUnival(root.left, value) &&
                    checkUnival(root.right, value);
        }
    }

    // ---------- Main Method ----------
    public static void main(String[] args) {
        int nodes[] = {5,3,3,-1,-1,3,-1,-1,3,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        if (tree.isUnivalTree(root)) {
            System.out.println("Valid Univalued Binary Tree");
        } else {
            System.out.println("Invalid Univalued Binary Tree");
        }
        //Invert a binary Tree
        System.out.println("Binary Tree Before Invert");
        preorder(root);
        root = invertBinaryTree(root);
        System.out.println("\nBinary Tree after Invert");
        preorder(root);
        int del = 3;
        System.out.println("\nDelete all child nodes that have value ="+del);
        root = deleteAllLeafWothValueK(root,del);
        preorder(root);
    }

    private static Node deleteAllLeafWothValueK(Node root, int del) {
        if(root == null){
            return null;
        }
        root.left = deleteAllLeafWothValueK(root.left,del);
        root.right = deleteAllLeafWothValueK(root.right,del);
        if(root.left == null && root.right == null){
            if(root.data == del){
                return null;
            }else{
                return root;
            }
        }
        return root;
    }

    private static void preorder(Node root){
        if(root != null){
            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    private static Node invertBinaryTree(Node root) {
        if(root == null){
            return root;
        }
        Node leftInverted = invertBinaryTree(root.left);
        Node rightInverted = invertBinaryTree(root.right);
        root.left = rightInverted;
        root.right = leftInverted;
        return root;
    }
}
