package lc;

public class P112_Path_Sum {
    // 二叉树是否有一条从根到叶的路径之和为sum. 思路:递归
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return backtrace(root, sum);
    }

    private boolean backtrace(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == target;
        }
        return backtrace(root.left, target - root.val) || backtrace(root.right, target - root.val);
    }
}