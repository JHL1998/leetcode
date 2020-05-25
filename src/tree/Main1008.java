package tree;

/**
 * 1008、先序遍历构造二叉树
 */
public class Main1008 {
    /**
     * 递归构造
     * @param pre
     * @return
     */
    public TreeNode bstFromPreorder(int[] pre) {
         return dfs(pre,0,pre.length-1);
    }
    private TreeNode dfs(int[]pre,int l,int r){
        if(l>r) return null;
        TreeNode root=new TreeNode(pre[l]);
        int k=l;
        //找到分割点 k前面的都是小于根节点的树，即左子树
        //k后面的树都是大于根节点的树，即右子树
        while(k<=r&&pre[k]<=pre[l]) k++;
        k-=l;
        root.left=dfs(pre,l+1,l+k-1);
        root.right=dfs(pre,l+k+1,r);
        return root;
    }

}
