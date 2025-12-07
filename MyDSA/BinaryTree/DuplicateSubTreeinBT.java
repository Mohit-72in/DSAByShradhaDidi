package MyDSA.BinaryTree;
import java.util.*;
public class DuplicateSubTreeinBT {
    static HashMap<String,Integer> hm;
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    static String inOrder(Node node){
        if(node == null){
            return "";
        }
        String str = "(";
        str += inOrder(node.left);
        str += Integer.toString(node.data);
        str += inOrder(node.right);
        str += ")";

        if(hm.get(str) != null && hm.get(str) == 1)
            System.out.println(node.data+ " ");
        if(hm.containsKey(str))
            hm.put(str,hm.get(str)+1);
        else
            hm.put(str,1);
        return str;
    }
    static void printAllDups(Node root){
        hm = new HashMap<>();
        inOrder(root);
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        printAllDups(root);
    }


}
