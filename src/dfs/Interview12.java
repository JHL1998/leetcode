package dfs;

/**
 * 面试题12、矩阵中的路径
 */
public class Interview12 {
    private int m,n;

    /**
     * dfs+回溯
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0) return false;
        m=board.length;
        n=board[0].length;
        char c[]=word.toCharArray();
        boolean[][]vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==c[0]){
                    if(dfs(board,i,j,c,vis,0)) return true;
                }
            }
        }
        return false;
    }
    private   boolean dfs(char [][]board,int i,int j,char []c,boolean[][]vis,int index){
        if(index==c.length) return true;
        if(i<0||i>=m||j<0||j>=n||vis[i][j]==true||board[i][j]!=c[index]) return false;
        vis[i][j]=true;
        boolean flag=dfs(board,i+1,j,c,vis,index+1)||
                dfs(board,i-1,j,c,vis,index+1)||
                dfs(board,i,j-1,c,vis,index+1)||
                dfs(board,i,j+1,c,vis,index+1);
        vis[i][j]=false;
        return flag;
    }
}
