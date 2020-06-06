package dfs;

/**
 * 200、岛屿数量
 */
public class Main200 {
    /**
     * 经典dfs求联通块数量
     * @param grid
     * @return
     */
   private int m,n;
    public int numIslands(char[][] grid) {
        if(grid.length==0||grid==null) return 0;
        m=grid.length;
        n=grid[0].length;
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
     }
     private void dfs(char[][]grid,int i,int j){

        if(i>=0&&i<=m-1&&j>=0&&j<=n-1&&grid[i][j]=='1'){
            grid[i][j]='2';
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
        }
     }
}
