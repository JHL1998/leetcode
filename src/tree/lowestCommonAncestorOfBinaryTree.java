package tree;

/**
 * 236、二叉树的最近公共祖先
 * 递归思想
 */
public class lowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode=lowestCommonAncestor(root.right,p,q);
        if(leftNode==null) return rightNode;
        if(rightNode==null) return leftNode;
        return root;
    }
}
