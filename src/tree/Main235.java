package tree;

/**
 * create by luojianhua
 */

/**
 * LCA问题
 */
public class Main235 {

    /**
     * 如果我们按照直接解决普通二叉树的LCA问题中解决的话 有一点overflow，
     * 没有利用二分搜索树的特性
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
            if(root==null||p==root||q==root) return root;
            TreeNode l=lowestCommonAncestor(root.left,p,q);
            TreeNode r=lowestCommonAncestor(root.right,p,q);
            if(l==null&&r==null) return root;
            if(l==null) return r;
            if(r==null) return l;
            return root;
    }

}

/**
 * 利用二叉搜索树的特性
 */
class Main_2{
    private TreeNode res=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            lca(root,p,q);
            return res;
    }
    private void lca(TreeNode root,TreeNode p,TreeNode q){
            if((root.val-p.val)*(root.val-q.val)<=0) res=root;
            else if(root.val<p.val&&root.val<q.val)  lca(root.right,p,q);
            else lca(root.left,p,q);
    }
}
