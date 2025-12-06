package MyDSA.BinaryTree;

public class MinDisBw2Nodes {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n1 = 2,n2 = 6;
        System.out.println(mindistanceBtwnNodes(root,n1,n2));



    }

    private static int mindistanceBtwnNodes(Node root, int n1, int n2) {
        Node lca = lca3(root,n1,n2);

        int leftDis = getDis(lca,n1);
        int rightDis = getDis(lca,n2);

        return leftDis+rightDis;

    }

    private static Node lca3(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = lca3(root.left,n1,n2);
        Node rightLca = lca3(root.right,n1,n2);

        if(leftLca == null){
            return rightLca;
        }
        if(rightLca == null){
            return leftLca;
        }
        return root;
    }

    private static int getDis(Node node, int n1) {
        if(node == null){
            return -1;
        }
        if(node.data == n1){
            return 0;
        }
        int leftdis = getDis(node.left,n1);
        int rightdis = getDis(node.right,n1);
        if(leftdis == -1 && rightdis == -1){
            return -1;
        }else if(leftdis == -1){
            return rightdis+1;
        }else{
            return leftdis+1;
        }

    }
}
