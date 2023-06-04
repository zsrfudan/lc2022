package lc;

import java.util.*;

public class P103_Binary_Tree_Zigzag_Level_Order_Traversal {

    class TreeNode {
        int val;
        TreeNode left,right;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            int size = queue.size();
            Stack<Integer> stack = new Stack();
            for (int i = 0 ; i < size ; i++) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
                if (level % 2 == 0) {
                    stack.push(tmpNode.val);
                } else {
                    subResult.add(tmpNode.val);
                }
            }
            while(!stack.isEmpty()) {
                subResult.add(stack.pop());
            }
            result.add(subResult);
            level++;
        }
        return result;
    }
}