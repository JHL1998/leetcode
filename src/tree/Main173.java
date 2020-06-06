package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 173、二叉搜索树迭代器
 */
public class Main173 {

    /**
     * 利用二分搜索树的中序遍历的性质
     */
    private Deque<Integer> list=new LinkedList<>();
    public Main173(TreeNode root) {
        inOrder(root);

    }
    private void inOrder(TreeNode root){
        if(root==null) return ;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return list.removeFirst();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }
}


class Main173_2 {

    private Stack<TreeNode> stack;

    /**
     * 利用栈模拟中序遍历，O(h)的时间复杂度
     * @param root
     */
    public Main173_2 (TreeNode root) {
        stack=new Stack<>();
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur=stack.pop();
        int res=cur.val;
        if(cur.right!=null){
            cur=cur.right;
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}


