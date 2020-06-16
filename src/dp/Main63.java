package dp;

/**
 * 63、不同路径
 */
public class Main63 {
    /**
     * 与上一题相比 ，只是多了一个 对该位置的判断。其余全是重复代码。。。。
     * @param nums
     * @return
     */
    public int uniquePathsWithObstacles(int[][] nums) {
        if(nums.length==0||nums[0].length==0) return 0;
        int m=nums.length;
        int n=nums.length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums[i][j]==1) continue;
                if(i==0&&j==0) dp[i][j]=1;
                else if(i==0) dp[i][j]=dp[i][j-1];
                else if(j==0) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
