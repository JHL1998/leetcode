package dfs;

/**
 * 面试题13、机器人的运动范围
 */
public class Interview13 {

    public int movingCount(int m, int n, int k) {
        boolean [][]vis=new boolean[m][n];
          return dfs(0,0,m,n,k,vis);
    }
    private int dfs(int i,int j,int m,int n,int k,boolean[][]vis){
         if(i<0||i>=m||j<0||j>=n||vis[i][j]==true||(i/10+i%10+j/10+j%10)>k){
             return 0;
         }
         vis[i][j]=true;
         return dfs(i+1,j,m,n,k,vis)+dfs(i,j+1,m,n,k,vis)+1;
    }

}
