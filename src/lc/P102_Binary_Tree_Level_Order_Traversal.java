package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102_Binary_Tree_Level_Order_Traversal {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            int size = queue.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode now = queue.poll();
                subResult.add(now.val);
                if (now.left != null) {
                    queue.offer(now.left);
                }
                if (now.right != null) {
                    queue.offer(now.right);
                }
            }
            result.add(subResult);
        }
        return result;
    }
}