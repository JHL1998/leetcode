package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 297、二叉树的序列化和反序列化
 */
public class Main297 {
    /**
     * 利用前序遍历 我们将空节点序列化成null
     * @param root
     * @return
     */
    private StringBuilder sb=new StringBuilder();
    public String serialize(TreeNode root) {
           dfs_s(root);
           return sb.toString();
    }
    private void dfs_s(TreeNode root){
        if(root==null){
            sb.append("null,");
                    return ;
        }
        //进行前序遍历
        sb.append(root.val);
        sb.append(",");
        dfs_s(root.left);
        dfs_s(root.right);
    }

    public TreeNode deserialize(String data) {
        String[]strs=data.split(",");
        //这里用LinkedList效率更高一点
        List<String>list=new ArrayList<>(Arrays.asList(strs));
         return dfs_d(list);
    }

    private TreeNode dfs_d(List<String>list){

         if(list.get(0).equals("null")){
             list.remove(0);
             return null;
         }
         TreeNode root=new TreeNode(Integer.parseInt(list.get(0)));
         list.remove(0);
         root.left=dfs_d(list);
         root.right=dfs_d(list);
         return root;
    }
}
