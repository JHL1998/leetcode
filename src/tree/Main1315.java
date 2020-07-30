package tree;

/**
 * create by luojianhua
 */

/**
 * 1315、祖父节点值为偶数的节点和
 *
 * 按照题意求得即可
 */
public class Main1315 {
    public int sumEvenGrandparent(TreeNode root) {
        int res=0;
        if(root==null) return res;
        if(root.val%2==0){

            if(root.left!=null){
                if(root.left.left!=null)  res+=root.left.left.val;
                if(root.left.right!=null) res+=root.left.right.val;
            }
            if(root.right!=null){
                if(root.right.left!=null) res+=root.right.left.val;
                if(root.right.right!=null) res+=root.right.right.val;
            }

        }
        return res+sumEvenGrandparent(root.left)+sumEvenGrandparent(root.right);
    }
}
