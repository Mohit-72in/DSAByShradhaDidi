package MyDSA.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Binarytree {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }

    static class buildTrees{
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
            if(root == null) return;
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        // Level order (BFS)
        public static void levelOrder(Node root){
            if(root == null) return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while(!queue.isEmpty()){
                Node popped = queue.poll();

                if(popped == null){
                    System.out.println();
                    if(!queue.isEmpty()){
                        queue.add(null);
                    }
                } else {
                    System.out.print(popped.data + " ");
                    if(popped.left != null) queue.add(popped.left);
                    if(popped.right != null) queue.add(popped.right);
                }
            }
        }

        // Correct inorder traversal
        public static void inOrder(Node root){
            if(root == null) return;
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
        public static int countNodes(Node root){
            if(root == null){
                return 0;
            }
            if(root.left == null && root.right == null) return 1;
            return countNodes(root.left)+countNodes(root.right);
        }
        public static int countLeaves(Node root){
            if(root == null){
                return 0;
            }
            return countLeaves(root.left)+countLeaves(root.right)+1;
        }

        public static int height(Node root) {
            if(root == null){
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
        static class TreeInfo{
            int ht;
            int dia;
            TreeInfo(int ht,int dia){
                this.ht = ht;
                this.dia = dia;
            }
        }
        public static TreeInfo diameterON(Node root){
            if(root == null){
                return new TreeInfo(0,0);
            }
            TreeInfo left = diameterON(root.left);
            TreeInfo right = diameterON(root.right);
            int myHt = Math.max(left.ht,right.ht)+1;
            int dia1 = left.dia;
            int dia2 = right.dia;
            int dia3 = left.ht + right.ht+1;
            int myDia = Math.max(dia1,Math.max(dia2,dia3));
            TreeInfo result = new TreeInfo(myHt,myDia);
            return result;
        }
    }

    public static void main(String[] args){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTrees.buildTree(nodes);

        System.out.print("Preorder: ");
        buildTrees.preOrder(root);

        System.out.println("\nLevel Order:");
        buildTrees.levelOrder(root);

        System.out.print("\nInorder: ");
        buildTrees.inOrder(root);
        System.out.println("Total  leaf Nodes :"+buildTrees.countLeaves(root));
        System.out.println("Total Nodes :"+buildTrees.countNodes(root));
        System.out.println("Height Of Tree :"+buildTrees.height(root));
        System.out.println("Diameter Of Tree : "+ buildTrees.diameterON(root).dia);
    }
}
