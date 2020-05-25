package tree;

import java.util.Stack;

/**
 * 538、把二叉搜索树转换为累加树
 * 递归思想 中序遍历为left->root->right  反过来就是right->root->left 从大到小累加
 */
public class Main538 {
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        travsal(root);
        return root;

    }
    private void travsal(TreeNode node){
        if(node==null) return ;
        travsal(node.right);
        sum+=node.val;
        node.val=sum;
        travsal(node.left);
    }
}

/**
 * 非递归
 */
 class convertBstToGreaterTree2{
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.right;
            }else{
                cur=stack.pop();
                sum+=cur.val;
                cur.val=sum;
                cur=cur.left;
            }
        }
        return root;
    }
}