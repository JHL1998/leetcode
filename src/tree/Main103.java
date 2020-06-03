package tree;

import java.util.*;

/**
 * 103、二叉树的锯齿形层次遍历
 */
public class Main103 {
    /**
     * 普通层序遍历加一个反转
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode cur=queue.poll();
                list.add(cur.val);
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
            //如果 层数为奇数，反转集合
            if(count%2==1) Collections.reverse(list);
            count++;
            res.add(new ArrayList<>(list));

        }
        return res;
    }
}
