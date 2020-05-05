package tree;

/**
 * 230、二叉搜索树中第k小的元素
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 最直接的做法，利用二叉搜索树的性质，我们使用中序遍历
 */
public class kthSmallestElementInBst {
    List<Integer> res=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        inOrder(root);
        return  res.get(k-1);
    }

    private void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.left);
        res.add(node.val);
        inOrder(node.right);
    }
}


