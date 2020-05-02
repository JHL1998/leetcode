package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513、BFS
 */
public class findBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            //找左下角的值，在遍历是从右往左
            if (cur.right != null) queue.add(cur.right);
            if (cur.left != null) queue.add(cur.left);

        }
        return cur.val;

    }
}

/**
 * 前序遍历，新的一层时，第一个节点一定是最左边的节点
 */
 class findBottomLeftTreeValue2 {
     private int res=0;
     private int maxDepth=0;
    public int findBottomLeftValue(TreeNode root) {

             dfs(root,1);
             return res;

    }
    private void dfs(TreeNode cur,int deepth){
        if(cur==null) return;
        //判断是否到达底部
        if(deepth>maxDepth){
            maxDepth=deepth;
            res=cur.val;
        }
        dfs(cur.left,deepth+1);
        dfs(cur.right,deepth+1);
    }
}


