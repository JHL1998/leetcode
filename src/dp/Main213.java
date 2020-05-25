package dp;

/**
 * 213、打家劫舍2
 */
public class Main213 {
    /**
     * 此题的有意思地方在于我们可以设置两个dp数组
     * @param nums
     * @return
     */
    public static  int rob(int[] nums) {
          if(nums.length==0) return 0;
          int n=nums.length;
          if(n==1) return nums[0];
          if(n==2) return Math.max(nums[0],nums[1]);
          if(n==3) return Math.max(Math.max(nums[0],nums[1]),nums[2]);
          //抢最后一家，不抢第一家
        int dp1[]=new int[n+1];
        dp1[0]=0;
        dp1[1]=nums[1];
        for(int i=2;i<n;i++){
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        }
        //抢第一家，不抢最后一家
        int dp2[]=new int[n+1];
        dp2[0]=nums[0];
        dp2[1]=nums[0];
        for(int i=2;i<n-1;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        //这里由于不抢最后一家，即最后应该是求dp2[n-2]
        return  Math.max(dp1[n-1],dp2[n-2]);
    }


}
