package Tree;

/** 543、
 * 此题转换为求任意节点左右子树高度和的最大值
 * root的直径为左子树高度+右子树高度
 * root的高度max{左子树高度，右子树高度}+1
 */
public class diameterOfBinaryTree {
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode node){
        if(node==null) return 0;
        //左子树高度
        int ld=dfs(node.left);
        //右子树高度
        int rd=dfs(node.right);
        max=Math.max(max,ld+rd);
        return Math.max(ld,rd)+1;

    }
}
