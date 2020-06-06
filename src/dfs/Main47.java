package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47、全排列2
 * 此题在全排列的基础上，引入了返回所有不重复全排列的条件
 */
public class Main47 {
    private List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
         if(nums.length==0) return res;
         //为了去重，先排序，将相等的数字放在一起
        Arrays.sort(nums);
        boolean []vis=new boolean[nums.length];
        dfs(nums,0,new ArrayList<>(),vis);
        return res;

    }
    private void dfs(int[]nums,int pos,List<Integer>list,boolean[]vis){
        if(pos==nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            //在这里我们判断这个数能不能选的前提是：
            //如果是一个元素，我们当然可以选，如果相邻两个元素不相等我们也可以选
            //最后一种情况就是如我们所说的，如果两个元素相等，
            //并且第一个元素选了，我们才能选择第二个
            if(vis[i]==false&&(i==0||nums[i]!=nums[i-1]||vis[i-1]==true)){
                list.add(nums[i]);
                vis[i]=true;
                dfs(nums,pos+1,list,vis);
                vis[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}
