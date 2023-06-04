package lc;

import java.util.LinkedList;
import java.util.Queue;

public class P111_Minimum_Depth_of_Binary_Tree {

    // 二叉树的最小深度，广度优先比深度优先思路好理解，找到第一个叶子节点
    public int minDepth(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()) {
            result++;
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode now = q.poll();
                if (now.left == null && now.right == null) {
                    return result;
                }
                if (now.left != null) {
                    q.offer(now.left);
                }
                if (now.right != null) {
                    q.offer(now.right);
                }
            }
        }
        return result;
    }
}