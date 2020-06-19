package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117、填充每个节点的下一个右侧节点指针II
 */
public class Main117 {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

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

    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left != null) {

            //右子树不为空
            if (root.right != null) root.left.next = root.right;
                //右子树为空
            else root.left.next = nextNode(root.next);
        }
        if (root.right != null) {
            root.right.next = nextNode(root.next);
        }
        //这里一定要注意先连接右子树
        //如果先递归左子树，会出现左边无法与右边相连的可能
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node nextNode(Node node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return node;
    }
}

/**
 * 借助BFS
 */
class Main117_1 {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public Node connect(Node root) {
            if (root == null) return root;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    Node cur = queue.poll();
                    if (i < n - 1) cur.next = queue.peek();
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                }
            }
            return root;
        }
    }
}
