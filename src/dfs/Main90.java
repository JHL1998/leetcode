package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90、子集2
 */
public class Main90 {
    /**
     * 与78题类似，不过引入了不包含重复子集的要求
     */
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null||nums.length==0) return res;
        //不要忘记排序
        Arrays.sort(nums);
        boolean[]vis=new boolean[nums.length];
        dfs(nums,0,new ArrayList<>(),vis);
        return res;
    }
    private void dfs(int []nums,int pos,List<Integer>list,boolean[]vis){
        if(pos==nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        //与之前的全排列一样，如果需要选的话
        if(vis[pos]==false&&(pos==0||nums[pos]!=nums[pos-1]||vis[pos-1]==true)){
            list.add(nums[pos]);
            vis[pos]=true;
            dfs(nums,pos+1,list,vis);
            vis[pos]=false;
            list.remove(list.size()-1);
        }

        //不选
        dfs(nums,pos+1,list,vis);


    }
}
