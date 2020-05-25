package tree;

/**
 * 判断一棵树是不是平衡二叉树，可以沿用我们在设计AVL树时的思想，求高度
 */
public class Main110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)>=0;
    }
    private int getHeight(TreeNode node){
        if(node==null) return 0;
        int lh=getHeight(node.left);
        int rh=getHeight(node.right);
        //平衡
        if(lh>=0&&rh>=0&&Math.abs(lh-rh)<=1) return Math.max(lh,rh)+1;
        return -1;
    }
}


