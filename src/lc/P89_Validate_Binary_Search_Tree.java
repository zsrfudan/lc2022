package lc;

import java.util.Stack;

public class P89_Validate_Binary_Search_Tree {

    // 方法1：递归判断字数是否满足左小右大
    // 方法2：中序遍历
    //    2.1 中序遍历递归
    //    2.2 中序遍历非递归
    class TreeNode {
        int val;
        TreeNode left,right;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;
        while(now != null) {
            stack.push(now);
            now = now.left;
        }
        TreeNode pre = null;
        while(!stack.isEmpty()) {
            now = stack.pop();
            if (pre != null && !(pre.val < now.val)) {
                return false;
            }
            pre = now;
            now = now.right;
            while(now != null) {
                stack.push(now);
                now = now.left;
            }
        }
        return true;
    }
}