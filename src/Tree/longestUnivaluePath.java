package Tree;

/**
 * 687、
 * 同543 and 124
 * 这是的路径用边长代替
 *
 */
public class longestUnivaluePath {

    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftSize = dfs(node.left);
        int rightSize = dfs(node.right);
        if (leftSize > 0 && node.left.val != node.val) {
            //不符合路径，将边长重置
            leftSize = 0;
        }
        if (rightSize > 0 && node.right.val != node.val) {
            //不符合路径，将边长重置
            rightSize = 0;
        }
        max = Math.max(max, leftSize + rightSize);
        return Math.max(leftSize, rightSize) + 1;
    }

}
