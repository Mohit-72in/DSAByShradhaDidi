package MyDSA.BinaryTree;

public class LCA {
    public static void main(String[] args) {
        SubTree.Node root = new SubTree.Node(1);
        root.left = new SubTree.Node(2);
        root.left.left = new SubTree.Node(4);
        root.left.right = new SubTree.Node(5);
        root.right = new SubTree.Node(3);
        root.right.left = new SubTree.Node(6);
        root.right.right = new SubTree.Node(7);

        int n1= 4,n2 = 7;
        int dis = minimunDistance(root,n1,n2);
        System.out.println("minDis :"+dis);
        int data = getTreeSum(root);
        preorder(root);

    }

    private static void preorder(SubTree.Node root) {
        if(root != null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    private static int getTreeSum(SubTree.Node root) {
        if(root == null) return 0;
        int data = root.data;
        int leftChild = getTreeSum(root.left);
        int rightChild = getTreeSum(root.right);

        int leftSum = root.left == null ? 0:root.left.data;
        int rightSum = root.right == null ? 0:root.right.data;
        root.data = leftChild+rightChild+leftSum+rightSum;
        return data;

    }

    private static int minimunDistance(SubTree.Node root, int n1, int n2) {
        MyDSA.BinaryTree.SubTree.Node lca = lca(root,n1,n2);

        int dis1 = getDistance(lca,n1);
        int dis2 = getDistance(lca,n2);
        return dis1 + dis2;
    }

    private static int getDistance(SubTree.Node lca, int n1) {
        if(lca == null) return -1;
        if(lca.data == n1) return 0;
        int leftDis = getDistance(lca.left,n1);
        int rigDis = getDistance(lca.right,n1);
        if(leftDis == -1 && rigDis == -1){
            return -1;
        }
        if(leftDis == -1){
            return rigDis+1;
        }else{
            return leftDis+1;
        }
    }

    private static SubTree.Node lca(SubTree.Node root,int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        SubTree.Node leftChild = lca(root.left,n1,n2);
        SubTree.Node rightChild = lca(root.right,n1,n2);

        if(leftChild == null){
            return rightChild;
        }
        if(rightChild == null){
            return leftChild;
        }
        return root;
    }

}
