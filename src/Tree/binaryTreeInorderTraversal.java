package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94、中序遍历是一种非常有用的性质，二分搜索树的中序遍历出来是一个递增的序列
 * 递归
 */
public class binaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inOrder(root,res);
        return res;
    }

    private void inOrder(TreeNode node,List<Integer> res){
        if(node==null) return ;
        inOrder(node.left,res);
        res.add(node.val);
        inOrder(node.right,res);

    }
}

/**
 * 利用栈实现模拟非递归中序遍历
 * 中序遍历顺序为left->root->right
 *
 *
 */
 class binaryTreeInorderTraversal2 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer>res=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        //先判断当前结点是否存在，若存在则将该节点放入栈中，再将当前结点设置为结点的左孩子，
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                // 若不存在则取栈顶元素为cur，当且仅当栈空cur也为空，循环结束。
                cur=stack.pop();
                res.add(cur.val);
                cur=cur.right;
            }
        }
        return res;

    }


}

