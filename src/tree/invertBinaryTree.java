package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226、递归实现
 */
public class invertBinaryTree {

    public TreeNode invertTree(TreeNode root){
        if(root==null) return null;
        //保存left指针
        TreeNode leftTree=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(leftTree);

       return root;

    }
}

/**
 *BFS/层序遍历， 直接交换左右两个节点
 */
 class invertBinaryTree2 {

    public TreeNode invertTree(TreeNode root){
        if(root==null) return null;
       Queue<TreeNode> queue=new LinkedList<>();
       queue.add(root);
       while(!queue.isEmpty()){
           TreeNode cur=queue.poll();
           TreeNode temp=cur.right;
           cur.right=cur.left;
           cur.left=temp;
           if(cur.left!=null) queue.add(cur.left);
           if(cur.right!=null) queue.add(cur.right);
       }
       return root;
    }
}


