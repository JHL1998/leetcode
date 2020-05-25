package dp;

/**
 * 53、最大子序和
 */
public class Main53 {
    /**
     * dp思路  dp[i-1]<0 dp[i]=nums[i]
     *        dp[i-1]>0 dp[i]=dp[i-1]+nums[i]
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int dp = nums[0];
        int res = dp;
        for (int i = 1; i < nums.length; i++) {
            if (dp <= 0) dp = nums[i];
            else dp += nums[i];
            res = Math.max(res, dp);
        }
        return res;
    }

}
