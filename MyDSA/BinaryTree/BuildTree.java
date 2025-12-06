package MyDSA.BinaryTree;

import MyDSA.Pragmatix.LinkedList.DoubleLL;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;


public class BuildTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int datq){
            this.data = datq;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public void postOrder(Node root) {
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public int countNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftcount = countNodes(root.left);
            int rightcount = countNodes(root.right);
            return  leftcount+rightcount+1;
        }

        public int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum+rightSum+root.data;
        }

        //Height Of Tree
        public int height(Node root){
            if(root == null){
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int myHeight = Math.max(leftHeight,rightHeight)+1;

            return myHeight;
        }
// t.c = O(N^2) since height and diameter is calculated one by one so that every node is touched twice
        public int diameterN2(Node root){
            if(root == null){
                return 0;
            }
            int dia1 = diameterN2(root.left);
            int dia2 = diameterN2(root.right);
            int dia3 = height(root.left)+height(root.right)+1;
            return Math.max(dia1,Math.max(dia2,dia3));
        }
        static class TreeInfo{
            int ht;
            int dia;
            TreeInfo(int h,int d){
                ht = h;
                dia = d;
            }
        }
        public static TreeInfo diameterON(Node root){
            if(root == null){
                return new TreeInfo(0,0);
            }
            TreeInfo left = diameterON(root.left);
            TreeInfo right = diameterON(root.right);
            int myHt = Math.max(left.ht, right.ht) + 1;

            int dia1 = left.dia;
            int dia2 = right.dia;
            int dia3 = left.ht+right.ht+1;
            int myDia = Math.max(dia1,Math.max(dia2,dia3));
            TreeInfo myInfo = new TreeInfo(myHt,myDia);
            return myInfo;
        }


        public void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(curr.data+" ");
                    if(curr.left != null)
                        q.add(curr.left);
                    if(curr.right != null)
                        q.add(curr.right);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Tree Created SuccessFully! ");
        tree.preOrder(root);
        System.out.println("\nInOrder Traversal is:");
        tree.inOrder(root);
        System.out.println("\nPostOrder Traversal is:");
        tree.postOrder(root);
        System.out.println("\nLevelOrder Traversal is:");
        tree.levelOrder(root);
        System.out.println("Total Num Of Nodes is : "+tree.countNodes(root));

        System.out.println("Total Sum Of Nodes is : "+tree.sumOfNodes(root));
        System.out.println("Total Height Of Tree is : "+tree.height(root));
        System.out.println("Diameter of Tree is : "+tree.diameterN2(root));
        System.out.println("Optiomal Approach ");
        System.out.println("Diameter of Tree is : "+tree.diameterON(root).dia);


    }
}
