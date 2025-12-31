package Tree;
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//}

class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return validate(node.left, min, node.val)
                && validate(node.right, node.val, max);
    }
}

public class ValidBST {

    public static void main(String[] args) {

        /*
              5
             / \
            3   7
           / \   \
          2   4   8
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        ValidateBST solution = new ValidateBST();
        System.out.println("Is Valid BST: " + solution.isValidBST(root));
    }
}