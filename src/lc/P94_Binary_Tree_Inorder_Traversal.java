package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94_Binary_Tree_Inorder_Traversal {
    // 非递归的方式，左枝先全部入栈（记得初始化），然后弹
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;
        while(now != null) {
            stack.push(now);
            now = now.left;
        }
        while(!stack.isEmpty()) {
            now = stack.pop();
            result.add(now.val);
            now = now.right;
            while(now != null) {
                stack.push(now);
                now = now.left;
            }
        }
        return result;
    }
}