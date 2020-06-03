package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113、路径总和2
 */
public class Main113 {
    //dfs+回溯
    private List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return res;
        dfs(root,sum,new ArrayList<>());
        return res;
    }
    private void dfs(TreeNode root,int sum,List<Integer>list){
        if(root==null) return ;
        sum-=root.val;
        list.add(root.val);
        if(root.left==null&&root.right==null&&sum==0) res.add(new ArrayList<>(list));
        dfs(root.left,sum,list);
        dfs(root.right,sum,list);
        list.remove(list.size()-1);
    }
}
