package tree;

/**
 * create by luojianhua
 */

/**
 * 1367、二叉树的列表
 *
 * 与判断两颗子树类似，双递归
 */
public class Main1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null) return true;
        if(root==null) return false;
        return  helper(head,root)
                ||isSubPath(head,root.left)||isSubPath(head,root.right);
    }
    private boolean helper(ListNode head,TreeNode root){
        if(head==null) return true;
        if(root==null) return false;
        if(root.val!=head.val) return false;
        return helper(head.next,root.left)||helper(head.next,root.right);
    }
}
