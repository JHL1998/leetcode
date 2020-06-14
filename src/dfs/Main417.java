package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417、太平洋大西洋水流问题
 */
public class Main417 {
    /**
     * dfs搜索，建立两个 数组
     */
    private int m,n;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res=new ArrayList<>();
        if(matrix.length==0||matrix[0].length==0) return res;
        m=matrix.length;
        n=matrix[0].length;
        boolean  x[][]=new boolean[m][n];
        boolean p[][]=new boolean[m][n];


        for(int i=0;i<m;i++){
            dfs(matrix,i,0,p);
            dfs(matrix,i,n-1,x);
        }
        for(int i=0;i<n;i++){
            dfs(matrix,0,i,p);
            dfs(matrix,m-1,i,x);
        }



        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(x[i][j]&&p[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;

    }
    private void dfs(int [][] matrix,int i,int j,boolean[][] reach){
        if(reach[i][j]) return ;
        reach[i][j]=true;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        for(int k=0;k<4;k++){
            int a=i+dx[k];
            int b=j+dy[k];
            if(a<0||a>=m||b<0||b>=n||matrix[i][j]>matrix[a][b]) continue;
            dfs(matrix,a,b,reach);
        }
    }
}
