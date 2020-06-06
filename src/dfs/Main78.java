package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Main78 {

    /**
     * 标准的dfs+回溯
     */
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0) return res;

        dfs(nums,0,new ArrayList<>());
        return res;
    }

    /**
     * 每个数字只有选或者不选两种可能
     * @param nums
     * @param pos
     * @param list
     */
    private void dfs(int nums[],int pos,List<Integer>list){
        if(pos==nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        list.add(nums[pos]);
        dfs(nums,pos+1,list);
        list.remove(list.size()-1);
        dfs(nums,pos+1,list);

    }
}
