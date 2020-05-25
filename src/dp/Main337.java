package dp;

/**
 * 337、打家劫舍3
 */
public class Main337 {
    /**
     * 该问题是在一棵树上抢劫，即我们要考虑的就是抢不抢根节点
     * @param root
     * @return
     */
    public int rob(TreeNode root){
       int res[]=dp(root);
       return Math.max(res[0],res[1]);

    }

    /**
     * 关键点在于这个递归函数，我们设置返回值为一个大小为2的数组，其中arr[0]表示not_rob
     * arr[1]表示rob，即抢根节点
     * @param root
     * @return
     */
    private int[] dp(TreeNode root){
       if(root==null) return new int[]{0,0};
        int left[]=dp(root.left);
        int right[]=dp(root.right);
        //抢根节点,那么就不能抢根节点下一个数
        int rob=root.val+left[0]+right[0];
        //不抢根节点
        int not_rob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{not_rob,rob};

    }
}
