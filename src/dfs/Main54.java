package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class Main54 {
    /**
     * 碰到边界就转换方向
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
           List<Integer>res=new ArrayList<>();
           if(matrix==null||matrix.length==0) return res;
           int m=matrix.length;
           int n=matrix[0].length;
           int dx[]={-1,0,1,0};
           int dy[]={0,1,0,-1};
           boolean[][]vis=new boolean[m][n];
           int a=0,b=0,d=1;
           for(int i=0;i<m*n;i++){
               res.add(matrix[a][b]);
               vis[a][b]=true;
                int x=a+dx[d],y=b+dy[d];
                if(x<0||x>=m||y<0||y>=n||vis[x][y]==true){
                    d=(d+1)%4;
                    x=a+dx[d];
                    y=b+dy[d];
                }
                a=x;
                b=y;
           }
           return res;
    }
}
