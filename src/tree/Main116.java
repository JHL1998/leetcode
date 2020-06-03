package tree;

/**
 * 116、填充每个节点的下一个右侧节点指针
 */
public class Main116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 左子树的next就是右子树，右子树的next就是next的左子树
     * 参照题目中给出的图
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root==null||root.left==null) return root;
        root.left.next=root.right;
        if(root.next!=null) root.right.next=root.next.left;
        connect(root.left);
        connect(root.right);
        return root;

    }
}
