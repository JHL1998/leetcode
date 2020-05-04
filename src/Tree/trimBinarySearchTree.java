package Tree;

/**
 * 669、 修剪二叉搜索树，递归思想
 */
public class trimBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null) return null;
        //节点值太大，从左边修剪
        if(root.val>R) return trimBST(root.left,L,R);
        //节点值太小，从右边修剪
        if(root.val<L) return trimBST(root.right,L,R);

        //正常情况
        root.left=trimBST(root.left,L,R);
        root.right=trimBST(root.right,L,R);
        return root;
    }
}
