package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102、二叉树的层序遍历是一个很经典的模型，BFS套路的模版
 */
public class binaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer>list=new ArrayList<>();
            while(n>0){
                TreeNode cur=queue.poll();
                list.add(cur.val);
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
                n--;
            }
            res.add(new ArrayList<>(list));


        }
        return res;
    }
}
