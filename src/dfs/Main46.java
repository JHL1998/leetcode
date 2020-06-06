package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 46、全排列问题
 */
public class Main46 {

    /**
     * 经典的dfs+回溯算法
     */
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
          if(nums==null||nums.length==0) return res;
          boolean[]vis=new boolean[nums.length];
          dfs(nums,0,new ArrayList<>(),vis);
          return res;
    }
    private void dfs(int[]nums,int pos,List<Integer>list,boolean[]vis){
        if(pos==nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(vis[i]==false){
                list.add(nums[i]);
                vis[i]=true;
                dfs(nums,pos+1,list,vis);
                vis[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}
