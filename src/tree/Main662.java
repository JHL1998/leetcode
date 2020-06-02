package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662、二叉树最大宽度
 */
public class Main662 {



    /**
     * 这里默认根节点索引为1，这样左孩子索引为2*i,右孩子索引为2*i+1
     * @param root
     * @return
     */
     public int widthOfBinaryTree(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        //用于存放索引
        LinkedList<Integer>list=new LinkedList<>();
        queue.add(root);
        list.add(1);
        int res=1;
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode cur=queue.poll();
                int index=list.removeFirst();
                if(cur.left!=null){
                    //加入左子树索引
                    queue.add(cur.left);
                    list.add(2*index);
                }
                if(cur.right!=null){
                    //加入右子树索引
                    queue.add(cur.right);
                    list.add(2*index+1);
                }
            }
            //如果size为1，就不用判断直接返回1
            if(list.size()>=2){
                res=Math.max(res,1+list.getLast()-list.getFirst());
            }
        }
        return res;

     }
}
