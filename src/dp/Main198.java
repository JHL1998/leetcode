package dp;

/**
 * 198、打家劫舍1
 */
public class Main198 {
    /**
     * 该问题的关键就是我们选择最后一家，与01背包问题一样，
     * dp[i-1]表示打劫前i家总金额(这里数组下标从0开始)
     * dp[i]=Math.max(dp[i-1],dp[i-1]+nums[i])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length<=1) return nums.length==0?0:nums[0];
        int n=nums.length;
        int []dp=new int[n+1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];

    }
}
class Main198_1 {

    /**
     * 同样的，我们可以优化空间复杂度
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int pre1=0;
        int pre2=0;
        for(int i=0;i<nums.length;i++){
            int cur=Math.max(pre2+nums[i],pre1);
            pre2=pre1;
            pre1=cur;
        }
        return pre1;

    }
}


