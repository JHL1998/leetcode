package dfs;

/**
 * 695、岛屿的最大面积
 */
public class Main695 {
    /**
     * 同样利用dfs搜索四个方向，与联通块题目类似
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0) return 0;
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    res=Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;
    }
    private int dfs(int [][]grid,int i,int j){
        int count=0;
        if(i>=0&&i<=grid.length-1&&j>=0&&j<=grid[0].length-1&&grid[i][j]==1){
            count=1;
            grid[i][j]=2;
            count+=dfs(grid,i+1,j);
            count+=dfs(grid,i-1,j);
            count+=dfs(grid,i,j+1);
            count+=dfs(grid,i,j-1);
        }
        return count;
    }
}
