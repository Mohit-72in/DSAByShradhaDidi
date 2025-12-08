package MyDSA.BinaryTree;
import java.util.*;

public class DuplicateSubTreeinBT {

    static HashMap<String, Integer> hm;

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    // Use POSTORDER to uniquely identify subtrees
    static String serialize(Node root) {
        if (root == null) return "#";

        String left = serialize(root.left);
        String right = serialize(root.right);
        String str = root.data + "," + left + "," + right;

        hm.put(str, hm.getOrDefault(str, 0) + 1);

        // Print only the FIRST time the duplicate appears
        if (hm.get(str) == 2) {
            System.out.println("Duplicate Subtree Root: " + root.data);
        }

        return str;
    }

    static void printAllDups(Node root) {
        hm = new HashMap<>();
        serialize(root);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.right.left = new Node(2);
        root.right.left.left = new Node(4);

        root.right.right = new Node(4);

        printAllDups(root);
    }
}
