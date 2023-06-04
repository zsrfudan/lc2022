package lc;

public class P110_Balanced_Binary_Tree {

    private boolean result = true;

    int judge(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (result == false) {
            return 0;
        }
        int left = judge(root.left);
        if (result == false) {
            return 0;
        }
        int right = judge(root.right);
        if (Math.abs(left - right) > 1) {
            result = false;
        }
        return Math.max(left, right)  + 1;
    }

    // 递归判断，返回高度
    public boolean isBalanced(TreeNode root) {
        judge(root);
        return result;
    }
}