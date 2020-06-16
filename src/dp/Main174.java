package dp;

/**
 * 174、地下城游戏
 */
public class Main174 {
    /**
     * 此题我们采用 反向dp
     * dp[i][j]表示从i,j出发到终点所需要的最小健康值
     * @param nums
     * @return
     */
    public int calculateMinimumHP(int[][] nums) {
        int m=nums.length;
        int n=nums[0].length;
        int dp[][]=new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1&&j==n-1){
                    dp[i][j]=Math.max(1,1-nums[i][j]);
                }else if(i==m-1){
                    dp[i][j]=Math.max(1,dp[i][j+1]-nums[i][j]);
                }else if(j==n-1){
                    dp[i][j]=Math.max(1,dp[i+1][j]-nums[i][j]);
                }else{
                    dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-nums[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
