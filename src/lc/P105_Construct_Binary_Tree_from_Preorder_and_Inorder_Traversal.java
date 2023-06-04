package lc;

public class P105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    TreeNode build(int[] preorder, int preBegin, int[] inorder, int inBegin, int len) {
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = preorder[preBegin];
        int index;
        for (index = inBegin ; index < inorder.length ; index++) {
            if (inorder[index] == preorder[preBegin]) {
                break;
            }
        }
        root.left = build(preorder, preBegin + 1, inorder, inBegin, index - inBegin);
        root.right = build(preorder, preBegin + index - inBegin + 1, inorder, index + 1, len - index + inBegin - 1);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length < 1) {
            return null;
        }
        return build(preorder, 0, inorder, 0, preorder.length);
    }
}