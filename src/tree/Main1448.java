package tree;

/**
 * 1448、统计二叉树中好节点的数目
 */
public class Main1448 {
    //首先明确一点，根节点一定是个好节点
    private int res=1;
    public int goodNodes(TreeNode root){
        if(root==null) return 0;
        dfs(root.left,root.val);
        dfs(root.right,root.val);
        return res;

    }
    private void dfs(TreeNode root,int max){
        if(root==null) return ;
        if(root.val>=max){
            max=root.val;
            res++;
        }
        dfs(root.left,max);
        dfs(root.right,max);
     }
}
