package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 22、括号生成
 */
public class Main22 {
    /**
     * 典型的DFS
     */
    private List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0) return res;
        //n对括号，那么就会有n个左括号，n个右括号
        dfs(n,n,"");
        return res;

    }
    private void dfs(int left,int right,String str){
        if(left==0&&right==0) {
            res.add(str);
            return ;
        }
        if(left>0){
            dfs(left-1,right,str+"(");
        }
        if(left<right){
            dfs(left,right-1,str+")");
        }

    }
}
