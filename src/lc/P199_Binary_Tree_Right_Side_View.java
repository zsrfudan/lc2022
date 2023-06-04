package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199_Binary_Tree_Right_Side_View {

    // 层序遍历每层最后一个节点
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode tmp = q.poll();
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
                if (i == size - 1) {
                    result.add(tmp.val);
                }
            }
        }
        return result;
    }
}