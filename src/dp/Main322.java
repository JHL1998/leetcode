package dp;

import java.util.Arrays;

/**
 * 322、零钱兑换
 */
public class Main322 {
    /**
     * dp[n]为凑够n分硬币需要的数量，dp[n]=min{dp[n-coin]}+1
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
           if(amount<0||coins==null||coins.length==0) return -1;
           int dp[]=new int[amount];
           for(int i=1;i<=amount;i++){
               int min=Integer.MAX_VALUE;
               for(int coin:coins){
                   if(i-coin<0||dp[i-coin]<0) continue;
                   min=Math.min(min,dp[i-coin]);
               }
               if(min==Integer.MAX_VALUE){
                   dp[i]=-1;
               }else{
                   dp[i]=min+1;
               }
           }
           return dp[amount];
    }
}

class Main332_{
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i>=coin) dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];

    }
}
