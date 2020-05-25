package tree;

/**
 * 572、 检查t是否是s的子树，要么s和t相等，
 * 要么t和s的左子树相等，
 * 要么和他的右子树相等
 */
public class subtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(s==null) return false;

        return helper(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    /**
     * 判断两棵树是否相等
     * @param s
     * @param t
     * @return
     */
    private boolean helper(TreeNode s,TreeNode t){
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        if(s.val!=t.val) return false;
        return helper(s.left,t.left)&&helper(s.right,t.right);
    }
}

class subtreeOfAnotherTree_1 {
    /**
     * 直接将这棵树序列化， 空节点也要序列化，这样才能保证 序列化的字符串能恢复出唯一一棵树，
     * 前序遍历和后序遍历都可以,这里使用的是后序遍历
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null||t==null) return false;
        return postPrint(s).contains(postPrint(t));
    }
    private String postPrint(TreeNode root){
        StringBuilder sb=new StringBuilder();
        postPrint(sb,root);
        return sb.toString();
    }
    private String postPrint(StringBuilder sb,TreeNode node){
        if(node.left==null){
            sb.append(".!");
        }else{
            postPrint(sb,node.left);
        }

        if(node.right==null){
            sb.append(".!");
        }else{
            postPrint(sb,node.right);
        }
        sb.append(node.val).append("*!");
        return sb.toString();
    }
}




