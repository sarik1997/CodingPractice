package Tree;

import java.util.*;

public class BfsDfs {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int key) {
            data = key;
            left = right = null;
        }
    }

    static void preorder(TreeNode TreeNode) {
        if (TreeNode == null) return;

        // Traverse root
        System.out.print(TreeNode.data + " ");
        // Traverse left
        preorder(TreeNode.left);
        // Traverse right
        preorder(TreeNode.right);
    }

    static void inorder(TreeNode TreeNode) {
        if (TreeNode == null) return;

        // Traverse left
        inorder(TreeNode.left);
        // Traverse root
        System.out.print(TreeNode.data + " ");
        // Traverse right
        inorder(TreeNode.right);
    }

    static void postorder(TreeNode TreeNode) {
        if (TreeNode == null) return;

        // Traverse left
        postorder(TreeNode.left);
        // Traverse right
        postorder(TreeNode.right);
        // Traverse root
        System.out.print(TreeNode.data + " ");
    }

    static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*add left child to the queue */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*add right right child to the queue */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    static void averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Double> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double avg = 0.0;
            int leveLength = queue.size();
            for (int i = 0; i < leveLength; i++) {
                TreeNode tempNode = queue.poll();
                avg += tempNode.data;
                /* add left child to the queue */
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                /* add right right child to the queue */
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            list.add(avg / leveLength);
        }
        System.out.print(list + " ");
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            double avg = 0.0;
            int leveLength = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < leveLength; i++) {
                TreeNode tempNode = queue.poll();
                list.add(tempNode.data);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            result.add(list);
        }
        return result;

    }


    public static void main(String args[]) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        /**
         *                            0
         *                         1    2
         *                        3 4
         */
        System.out.println("Inorder traversal");//   3 1 4 0 2
        inorder(root);

        System.out.println("\nPreorder traversal ");//DFS 0 1 3 4 2
        preorder(root);

        System.out.println("\nPostorder traversal"); //reverse BFS 3 4 1 2 0
        postorder(root);

        System.out.println("\nLevelorder traversal");//BFS 0 1 2 3 4
        printLevelOrder(root);

        System.out.println("\naverage sum at each level");
        averageOfLevels(root);

        System.out.println("\nEvery level value is grouped together" + levelOrder(root));
        System.out.println("\nGiven the root of a binary tree, return the zigzag level order traversal of its nodes'" +
                "\nvalues. (i.e., from left to right, then right to left for the next level and alternate between).");
        List<List<Integer>> zigzag = levelOrder(root);
        for (int i = 0; i < zigzag.size(); i++)
            if (i % 2 != 0) {
                Collections.reverse(zigzag.get(i));
            }
        System.out.println(zigzag);

    }

}
