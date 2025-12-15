package MyDSA.BinaryTree;

import java.util.*;

public class BottomViewOfBT {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right.right = new TreeNode(25);

        bottomView(root);
    }

    private static void bottomView(TreeNode root) {

        if (root == null) return;

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        int min = 0, max = 0;

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;

            // overwrite → bottom-most node wins
            map.put(hd, node.val);

            min = Math.min(min, hd);
            max = Math.max(max, hd);

            if (node.left != null)
                q.offer(new Pair(node.left, hd - 1));

            if (node.right != null)
                q.offer(new Pair(node.right, hd + 1));
        }

        for (int i = min; i <= max; i++) {
            System.out.println(map.get(i));
        }
    }
}
