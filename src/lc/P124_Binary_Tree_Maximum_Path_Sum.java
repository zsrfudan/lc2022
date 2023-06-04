package lc;

public class P124_Binary_Tree_Maximum_Path_Sum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 从遍历思路上看是分治，分成三大块 左枝，右枝，当前点。
    // https://www.youtube.com/watch?v=9ZNky1wqNUw

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) { //root结点必选的这支树的局部最优解

        myMaxPathSum(root);
        return result;

    }

    int myMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(myMaxPathSum(root.left), 0);
        int rightMax = Math.max(myMaxPathSum(root.right), 0);
        int nowMax = leftMax + rightMax + root.val;
        result = Math.max(result, nowMax);  // 全局结果在这里判断
        return root.val + Math.max(leftMax, rightMax); // 作为下一步的局部结果，只能取一边
    }

}
