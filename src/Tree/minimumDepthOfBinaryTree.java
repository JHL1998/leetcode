package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 递归做法
 */
public class minimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null||root.right==null)
            return minDepth(root.left)+minDepth(root.right)+1;

        return Math.min(minDepth(root.right),minDepth(root.left))+1;


    }
}

/**
 * BFS 解决最短路径问题(最小深度实质上就是最短路径)
 */
 class minimumDepthOfBinaryTree2 {

    public int minDepth(TreeNode root) {
        if(root==null) return 0;
         Queue<TreeNode> queue=new LinkedList<>();
         //初始化为1
         int res=1;
         queue.add(root);
         while(!queue.isEmpty()){
             int n=queue.size();
             //队列中的所有节点向四周扩散
             for(int i=0;i<n;i++){
                 TreeNode cur=queue.poll();
                 //到达叶子节点
                 if(cur.left==null&&cur.right==null) return res;
                 if(cur.left!=null) queue.add(cur.left);
                 if(cur.right!=null) queue.add(cur.right);

             }
             //更新步数
             res++;
         }
         return res;

    }
}
