package tree;

/**
 * create by luojianhua
 */

/**
 * 101、对称二叉树
 *
 *
 */
public class Main101 {

    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }
    private boolean helper(TreeNode l,TreeNode r){
        if(l==null&&r==null) return true;
        if(l==null||r==null)return false;
        return   l.val==r.val&&helper(l.left,r.right)&&helper(l.right,r.left);
    }
}
