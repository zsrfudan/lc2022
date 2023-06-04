package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P144_Binary_Tree_Preorder_Traversal {

//    List<Integer> result = new ArrayList<>();
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) {
//            return result;
//        }
//        result.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return result;
//    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;
        while(now != null) {
            result.add(now.val);
            stack.push(now);
            now = now.left;
        }
        while(!stack.isEmpty()) {
            now = stack.pop();
            now = now.right;
            while(now != null) {
                result.add(now.val);
                stack.push(now);
                now = now.left;
            }
        }
        return result;
    }

}