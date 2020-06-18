package tree;

/**
 * 1028、从先序遍历还原二叉树
 */
public class Main1028 {

    int index=0;
    int dep=0;
    public TreeNode recoverFromPreorder(String s) {
        return dfs(s,0);
    }
    private TreeNode dfs(String s,int h){
        if(index>=s.length()||dep!=h) return null;
        TreeNode root=new TreeNode(getNum(s));
        dep=getDep(s);
        root.left=dfs(s,h+1);
        root.right=dfs(s,h+1);
        return root;
    }
    //获得深度
    private int getDep(String s){
        int res=0;
        while(index<s.length()&&s.charAt(index)=='-'){
            res++;
            index++;
        }
        return res;


    }
    //获得数字
    private int getNum(String s){
        int res=0;
        while(index<s.length()&&s.charAt(index)!='-'){
            res=res*10+s.charAt(index)-'0';
            index++;
        }
        return res;
    }
}
