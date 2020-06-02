package tree;

/**
 *  129、求根到叶子节点数字之和
 */
public class Main129 {
    private int sum=0;
    public int sumNumbers(TreeNode root) {
        dfs(0,root);
        return sum;
    }


    private void dfs(int depth,TreeNode root){
        if(root==null) return ;
        //每加一层，要乘10
        int value=(depth*10+root.val);
        //到达叶子节点
        if(root.left==null&&root.right==null)  sum+=value;
        dfs(value,root.left);
        dfs(value,root.right);
    }
}
