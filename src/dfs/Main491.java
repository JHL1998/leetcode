package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491、递增子序列
 */
public class Main491 {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>>findSubsequences(int []nums){
           if(nums.length==0) return res;
           dfs(nums,new ArrayList<>(),0);
           return res;
    }
    private void dfs(int[]nums,List<Integer>list,int index){
         //当list中元素个数大于2个时
        if(list.size()>1) res.add(new ArrayList<>(list));
        //去重
        Set<Integer> set=new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            //保证是递增的，即新加入的元素要比集合中最后一个元素要大
            if(list.size()==0||nums[i]>=list.get(list.size()-1)){
                  set.add(nums[i]);
                  list.add(nums[i]);
                  dfs(nums,list,i+1);
                  list.remove(list.size()-1);
            }
        }

    }
}
