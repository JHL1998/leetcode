package Tree;

/**
 * 437、不需要从root开始，也不需要以leaf结尾
 */
public class pathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        int ans=helper(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
        return ans;

    }
    //从根节点开始计算
    private int helper(TreeNode root,int sum){
        if(root==null) return 0;
        int ans=0;
        if(root.val==sum) ans++;
        ans+=helper(root.left,sum-root.val)+helper(root.right,sum-root.val);
        return ans;
    }
}
