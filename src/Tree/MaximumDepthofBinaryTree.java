package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最简单的办法就是递归
 */
public class MaximumDepthofBinaryTree {

        public int maxDepth(TreeNode root) {
            return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }

}

/**
 * 使用广度优先遍历/层序遍历
 */
class MaximumDepthofBinaryTree2{
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int res=0;
        while(!queue.isEmpty()){
              int n=queue.size();
              for(int i=0;i<n;i++){
                  TreeNode cur=queue.peek();
                  if(cur.left!=null) queue.add(cur.left);
                  if(cur.right!=null) queue.add(cur.right);
                  queue.remove();
              }
              res++;
        }
        return res;
    }
}
