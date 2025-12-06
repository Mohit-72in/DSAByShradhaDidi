package MyDSA.BinaryTree;
import java.util.*;
public class SubTree {
    static class  Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        Node node;
        int hd;

        Info(Node node,int hd){
            this.node = node;
            this.hd = hd;
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

        Node subtree = new Node(2);
        subtree.left = new Node(4);
        subtree.right = new Node(5);

        System.out.println(isSubtree(root,subtree));
        topViewOfTree(root);
        System.out.println("\nKth Level Nodes are :");
        kthLevelNodes(root,1,2);
        int n1 = 4,n2 = 3;
        System.out.println("\nLowest Common Ansestor of n1: "+n1 + " and n2 :"+n2);
        System.out.println(lca(root,n1,n2));

        System.out.println("\nLowest Common Ansestor of n1: "+n1 + " and n2 :"+n2);
        System.out.println(lca2(root,n1,n2).data); // t.c = O(N) but stack call space take O(N) no any ectra space taken
    }

    public static Node lca2(Node root, int n1, int n2) {

        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = lca2(root.left, n1,n2);
        Node rightLca = lca2(root.right,n1,n2);

        if(leftLca == null){
            return rightLca;
        }
        if(rightLca == null){
            return leftLca;
        }
        return root;


    }

    private static int lca(Node root, int n1, int n2) {
        if(root == null){
            return -1;
        }
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        // traverse both path and find 1st common node in these two paths
        int i = 0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        // last node equal to (i-1)
        Node lca = path1.get(i-1);
        return lca.data;
    }
    private static boolean getPath(Node root,int n,ArrayList<Node> path){
        // base condition means no further node no path were exist
        if(root == null){
            return false;
        }
        // add root node to path
        path.add(root);

        if(root.data == n){
            return true;
        }
        boolean leftPath = getPath(root.left,n,path);
        boolean rightPath = getPath(root.right,n,path);

        if(leftPath || rightPath){
            return true;
        }
        // particular root wale path me khi node exist nhi krta isliye root ko path me hone se koi fyda nhi h
        path.remove(path.size()-1);
        return false;
    }

    private static void kthLevelNodes(Node root, int level,int k) {
        // base condition
        if(root == null){
            return;
        }
        // if nth level node encounter then print it and return means no need to traverse its child
        if(level == k){
            System.out.print(root.data + " ");
            return;
        }
        // root kth level nhi h tho recursive call krenge left child and right child means simply go down to search and find
        kthLevelNodes(root.left,level+1,k);
        kthLevelNodes(root.right,level+1,k);

    }

    private static void topViewOfTree(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        int min = 0,max = 0;
        q.add(new Info(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr = q.poll();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        for(int i = min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }

    }

    private static boolean isSubtree(Node root, Node subtree) {
        if(root == null) return false;
        if(root.data == subtree.data){
            return isIdentical(root,subtree);
        }
        return isSubtree(root.left,subtree) || isSubtree(root.right,subtree);
    }

    private static boolean isIdentical(Node root, Node subtree) {
        if(root == null && subtree == null){
            return true;
        }else if(root == null || subtree == null || root.data != subtree.data){
            return false;
        }
        if(!isIdentical(root.left, subtree.left)){
            return false;
        }
        if(!isIdentical(root.right,subtree.right)){
            return false;
        }
        return true;

    }
}
