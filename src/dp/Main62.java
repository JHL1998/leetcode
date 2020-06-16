package dp;

/**
 *
 */
public class Main62 {
    /**
     * 简单dp， 只可能从上面或者左边走下来，那么对应的就是
     * dp[i][j]=dp[i-1][j]+dp[i][j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) dp[i][j]=1;
                else if(i==0) dp[i][j]=dp[i][j-1];
                else if(j==0) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return  dp[m-1][n-1];
    }
}
