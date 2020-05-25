package dp;

/**
 * 887、鸡蛋掉落
 */
public class Main887 {
    /**
     *  如果在第i层碎了，此时鸡蛋还剩k-1个，并且 我们应该在[1,i-1]层，共i-1层中寻找
     *  如果在第i层没碎，此时鸡蛋还剩k个，并且我们应该在第[i+1,N] 共N-i层中寻找
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        //加入备忘录
        int [][]memo=new int[K+1][N+1];
        return dp(K,N,memo);

    }
    private int dp(int K,int N,int [][]memo){
        if(K==1) return N;
        if(N==0) return 0;
        if(memo[K][N]!=0) return memo[K][N];
        int l=1;
        int r=N;
        int res=Integer.MAX_VALUE;
        //引入二分法去寻找那个楼层
        while(l<=r){
            int mid=l+(r-l)/2;
            //鸡蛋碎了
            int broke=dp(K-1,mid-1,memo);
            //鸡蛋没碎
            int not_broke=dp(K, N-mid,memo);
            //找最坏情况
            if(broke>not_broke){
                r=mid-1;
                res=Math.min(res,broke+1);
            }else{
                l=mid+1;
                res=Math.min(res,not_broke+1);
            }
        }
        memo[K][N]= res;
        return res;
    }
}
