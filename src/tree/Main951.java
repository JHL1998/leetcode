package tree;

/**
 * create by luojianhua
 */

/**
 * 951、翻转等价二叉树
 *
 * 判断两个方向，LL，RR    LR，RL
 */
public class Main951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) return true;
        if(root1==null||root2==null||root1.val!=root2.val) return false;
        return (flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right))||
                (flipEquiv(root1.left,root2.right)&&flipEquiv(root1.right,root2.left));

    }
}
