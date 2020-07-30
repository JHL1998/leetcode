package tree;

/**
 * create by luojianhua
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 894、所有可能的满二叉树
 *
 * //由于根节点要用一个节点，即总节点数一定为奇数个节点
 *接下来我们枚举左子树和右子树的个数，
 * 如果左子树为i，那么右子树为N-1-i
 */
public class Main894 {
    public List<TreeNode> allPossibleFBT(int N){
        List<TreeNode> res=new ArrayList<>();
        if(N%2==0) return res;
         //如果只有一个节点
        if(N==1){
            TreeNode root=new TreeNode(0);
            res.add(root);
            return res;
        }

        for(int i=1;i<N;i++){
            //接下来我们枚举左子树和右子树的个数，
            //如果左子树为i，那么右子树为N-1-i
            List<TreeNode>l=allPossibleFBT(i);
            List<TreeNode>r=allPossibleFBT(N-i-1);
            for(TreeNode left:l){
                for (TreeNode right:r){
                    TreeNode root=new TreeNode(0);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }

        }
        return res;
    }
}
