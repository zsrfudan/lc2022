package lc;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;
}
public class P236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    // 1.二叉搜索树，特点左小右大，从根节点遍历找到第一个满足这个条件的结点 P235
    // 2.有指向父节点指针的树，退化成两个链表找最近公共结点
    // 3.分别深度遍历找到两个路径入栈

    public TreeNode lowestCommonAncestorForBST(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }


    boolean findPath(TreeNode root, TreeNode target, Stack<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.push(root);
        if (root == target) {
            return true;
        }
        if (findPath(root.left, target, path)) {
            return true;
        }
        if (findPath(root.right, target, path)) {
            return true;
        }
        path.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pathP = new Stack<>();
        Stack<TreeNode> pathQ = new Stack<>();
        findPath(root, p, pathP);
        findPath(root, q, pathQ);

        if (pathP.size() > pathQ.size()) {
            Stack<TreeNode> tmp = pathP;
            pathP = pathQ;
            pathQ = tmp;
        }

        int sizeGap = pathQ.size() - pathP.size();

        for (int i = 0 ; i < sizeGap ; i++) {
            pathQ.pop();
        }

        while(!pathP.isEmpty()) {
            if (pathP.peek() == pathQ.peek()) {
                return pathP.peek();
            }
            pathP.pop();
            pathQ.pop();
        }
        return null;

    }
}