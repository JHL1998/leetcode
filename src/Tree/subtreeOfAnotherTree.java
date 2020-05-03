package Tree;

/**
 * 572、 检查t是否是s的子树，要么s和t相等，
 * 要么t和s的左子树相等，
 * 要么和他的右子树相等
 */
public class subtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(s==null) return false;

        return helper(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    /**
     * 判断两棵树是否相等
     * @param s
     * @param t
     * @return
     */
    private boolean helper(TreeNode s,TreeNode t){
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        if(s.val!=t.val) return false;
        return helper(s.left,t.left)&&helper(s.right,t.right);
    }
}

