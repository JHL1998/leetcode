package tree;

/**
 * create by luojianhua
 */

/**
 *998、最大二叉树 II
 *
 * 如图所示
 * 如果给定的值大于根节点的值，我们直接生成新节点，将原来的树挂接在左边
 *
 * 否则的话将树挂在根节点右边
 */
public class Main998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(val>root.val){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        root.right=insertIntoMaxTree(root.right,val);
        return root;
    }
}
