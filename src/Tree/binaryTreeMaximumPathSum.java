package Tree;

/**
 * 124、也是遍历每一个节点，求路径和
 *
 */
public class binaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;

    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        //由于可能加上负数，这里过滤一下
        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));

        max = Math.max(max, leftSum + rightSum + node.val);
        return Math.max(leftSum, rightSum) + node.val;
    }

}
