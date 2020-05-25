package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637、BFS模版题
 */
public class Main637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Double> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            double sum=0;
            for(int i=0;i<n;i++){
                TreeNode cur=queue.poll();

                //通常在这里我们会写终止条件，但是这题没有终止条件
                sum+=cur.val;

                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
            res.add(sum/n);

        }
        return res;

    }
}
