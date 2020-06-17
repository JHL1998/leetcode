package dp;

import java.util.Arrays;

/**
 * 300、最长上升子序列
 */
public class Main300 {
    /**
     * dp
     * dp[i]表示以nums[i]结尾的最长上升子序列
     * 时间O(n^2) 空间O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
           if(nums==null||nums.length==0) return 0;
           int n=nums.length;
           int dp[]=new int[n+1];
           int res=dp[0]=1;
           for(int i=1;i<n;i++){
               dp[i]=1;
               for(int j=0;j<i;j++){
                   if(nums[i]<=nums[j]) continue;
                   dp[i]=Math.max(dp[i],dp[j]+1);
               }
               res=Math.max(res,dp[i]);
           }
           return res;
    }
}

/**
 *
 * 这题采用二分的思路就是：
 * 维护一个数组，如果当前元素比该数组中所有元素都大的话，就追加在数组后面，
 * 这样就相当于最长上升子序列+1，否则的话就覆盖到第一个比他大的元素。
 * 因此我们利用二分搜索要寻找左边界
 *
 */
class Main300_1 {

    /**
     * 手动写二分
     * 时间O(nlogn) ,空间O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length;
        int res[]=new int[n];
        int len=0;
        for(int num:nums){
            int l=0,r=len;
            //二分搜索寻找左边界
            while(l<r){
                int mid=l+(r-l)/2;
                if(res[mid]<num) l=mid+1;
                else r=mid;
            }

            res[l]=num;
            if(l==len)len++;

        }
        return len;
    }
}

class Main300_2{
    /**
     * 利用Java 二分搜索API
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length;
        int res[]=new int[n];
        int len=0;
        for(int num:nums){
            int index= Arrays.binarySearch(res,0,len,num);
            index=index<0?-index-1:index;
            res[index]=num;
            if(index==len)len++;
        }
        return len;

    }
}







