package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 590、N叉树的后序遍历
 */
public class Main590 {
    /**
     * 递归做法
     */
    private List<Integer> list=new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root==null) return new ArrayList<>();
        postOrder(root);
        return list;
    }
    private void  postOrder(Node node){
        if(node==null) return ;
        for(Node child:node.children){
            postOrder(child);
        }
        list.add(node.val);
    }
}

class solution2{
    /**
     * 迭代法，利用两个栈
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer>list=new ArrayList<>();
        Stack<Node> stack1=new Stack<>();
        Stack<Node>stack2=new Stack<>();
        if(root==null) return list;
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node cur=stack1.pop();
            stack2.push(cur);
            for(Node child:cur.children){
                stack1.push(child);
            }
        }
        while(!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return list;

    }
}
