package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 437、不需要从root开始，也不需要以leaf结尾
 */
public class Main437 {
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        int ans=helper(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
        return ans;

    }
    //从根节点开始计算
    private int helper(TreeNode root,int sum){
        if(root==null) return 0;
        int ans=0;
        if(root.val==sum) ans++;
        ans+=helper(root.left,sum-root.val)+helper(root.right,sum-root.val);
        return ans;
    }
}

class Main437_2{

    /**
     * 前缀和
     */


    Map<Integer,Integer> map=new HashMap<>();
    int res=0;
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        //找到了一条路径
        map.put(0,1);
        count(root,sum,0);
        return res;
    }
    private void count(TreeNode root,int sum,int cur){
        cur+=root.val;
        res+=map.getOrDefault(cur-sum,0);
        map.put(cur,map.getOrDefault(cur,0)+1);
        if(root.left!=null) count(root.left,sum,cur);
        if(root.right!=null) count(root.right,sum,cur);
        map.put(cur,map.getOrDefault(cur,0)-1);
    }
}
