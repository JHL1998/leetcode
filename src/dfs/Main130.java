package dfs;

/**
 * 130、被围绕的区域
 */
public class Main130 {

    /**
     *本题我们只需要搜索边界即可， 如果边界为O我们将其转换为一个特殊的字符。
     * 然后遍历整个二维数组，最后还原即可
     */
    private int m,n;
    public void solve(char[][] board) {
        if(board==null|| board.length==0) return ;
        m=board.length;
        n=board[0].length;



        //左右两条边
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][n-1]=='O') dfs(board,i,n-1);
        }
        //上下两条边
        for(int j=0;j<n;j++){
            if(board[0][j]=='O') dfs(board,0,j);
            if(board[m-1][j]=='O')dfs(board,m-1,j);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //先把O换成X，否则的话最后结果全部是X
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='Y') board[i][j]='O';
            }
        }

    }
    private void dfs(char[][]board,int x,int y){
        //只有当边界值为O时我们才需要 继续搜索
        if(x<0||x>=m||y<0||y>=n||board[x][y]=='Y'||board[x][y]=='X') return;
        //把边界上的O换成Y
        board[x][y]='Y';
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int a=x+dx[i],b=y+dy[i];
            dfs(board,a,b);
        }
    }
}
