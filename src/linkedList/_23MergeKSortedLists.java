package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 */
public class _23MergeKSortedLists {

    /**
     * 最直接的办法，我们将每一个链表都放到一个集合中，然后进行排序
     * 此时链表中的引用并没有改变，我们还是可以合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length==0||lists==null) return null;
       List<ListNode>list=new ArrayList<>();
       //将每个节点都添加到集合中
       for(ListNode node:lists){
           list.add(node);
           node=node.next;
       }

       //按照元素升序排列
        list.sort((a,b)->a.val-b.val);
       //串起来
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
       for(ListNode node:list){
           cur.next=node;
           cur=cur.next;
       }
       return dummy.next;


    }
}
class _23MergeKSortedLists2 {

    /**
     * 利用优先队列，我们不必将所有值存进去，只需要将头节点存入
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0||lists==null) return null;
        PriorityQueue<ListNode> queue=new PriorityQueue<>((a, b)->a.val-b.val);
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        for(ListNode node:lists){
            if(node!=null) queue.add(node);
        }
        while(!queue.isEmpty()){
            cur.next=queue.poll();
            cur=cur.next;
            if(cur.next!=null) queue.add(cur.next);
        }
        return dummy.next;


    }
}


