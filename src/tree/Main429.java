package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429、N叉树的层序遍历
 */
public class Main429 {

    /**
     * 熟悉的BFS 背模版环节
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer>list=new ArrayList<>();
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node cur=queue.poll();
                list.add(cur.val);
                for(Node child:cur.children){
                    queue.add(child);
                }
            }
            res.add(new ArrayList<>(list));

        }
        return res;
    }
}
