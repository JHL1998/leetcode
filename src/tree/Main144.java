package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144、前序遍历是最二叉树中很重要的一个性质，递归实现
 */
public class Main144 {
    List<Integer> res=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        preOrder(root);
        return res;
    }

    private void preOrder(TreeNode node){
        if(node==null) return ;
        res.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}

/**
 * 非递归实现(利用栈后进先出)
 */

class binaryTreePreorderTraversal2{
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root==null) return new ArrayList<>();
        List<Integer>res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
              TreeNode cur=stack.pop();
              if(cur==null) continue;
              res.add(cur.val);
              //这里保证先遍历左孩子，所以先将右孩子压入栈
              stack.push(cur.right);
              stack.push(cur.left);

        }

        return res;

    }

}