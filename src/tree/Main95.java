package tree;

/**
 * create by luojianhua
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 95、不同的二叉搜索树 II
 */
public class Main95 {
    public List<TreeNode> generateTrees(int n) {
            if(n==0) return new ArrayList<>();
            return dfs(1,n);
    }
    private List<TreeNode>dfs(int l,int r){
        List<TreeNode> res=new ArrayList<>();
        if(l>r){
            res.add(null);
            return res;
        }
        //枚举根节点
        for(int i=l;i<=r;i++){
            List<TreeNode>  left=dfs(l,i-1);
            List<TreeNode>  right=dfs(i+1,r);
            for(TreeNode lh:left){
                for (TreeNode rh:right){
                    TreeNode root=new TreeNode(i);
                    root.left=lh;
                    root.right=rh;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
