package tree;

/**
 * create by luojianhua
 */

/**
 * 652、寻找重复的子树
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 利用先序遍历，将整棵树序列化，然后用哈希表保存经过的节点
 */
public class Main652 {
    private List<TreeNode> res=new ArrayList<>();
    private Map<String,Integer> map=new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root==null) return res;
        dfs(root);
        return res;

    }
    private String dfs(TreeNode root){
        if(root==null) return "";
        String s=root.val+","+dfs(root.left)+","+dfs(root.right);
        if(map.getOrDefault(s,0)==1) res.add(root);
        map.put(s,map.getOrDefault(s,0)+1);
        return s;
    }

}
