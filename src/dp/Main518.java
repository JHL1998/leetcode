package dp;

/**
 * 518、零钱兑换2
 */
public class Main518 {
    /**
     * 传统dp中，当 i-coin>=0时，才有解，这里我们直接从 j=coins[i]开始
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {

        int dp[]=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}

class Main518_{
    /**
     * 传统解法
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
         int dp[]=new int[amount+1];
         dp[0]=1;
         for(int coin:coins){
             for(int i=1;i<=amount;i++){
                 if(i>=coin) dp[i]+=dp[i-coin];
             }
         }
         return dp[amount];
    }
}

