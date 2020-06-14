package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091、二进制矩阵中的最短路径
 */
public class Main1091 {
    /**
     *  八个方向BFS标准模版
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
         if(grid[0][0]==1) return -1;
         int n=grid.length;
         int [][]direction={{-1,0},{1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
         boolean[][]vis=new boolean[n][n];
         Queue<int[]>queue=new LinkedList<>();
         int res=1;
         queue.add(new int[]{0,0});
         vis[0][0]=true;
         while(!queue.isEmpty()){
             int size=queue.size();
             for(int i=0;i<size;i++){
                 int[]cur=queue.poll();
                 //到达终点
                 if(cur[0]==n-1&&cur[1]==n-1) return res;
                 for(int []d:direction){
                     int a=d[0]+cur[0];
                     int b=d[1]+cur[1];
                     if(a<0||a>=n||b<0||b>=n||vis[a][b]||grid[a][b]==1) continue;
                     queue.add(new int[]{a,b});
                     vis[a][b]=true;
                 }
             }
             res++;
         }
 return -1;

    }
}
