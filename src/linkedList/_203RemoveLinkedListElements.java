package linkedList;

/**
 * 203、移除链表元素
 */
public class _203RemoveLinkedListElements {
    /**
     * 递归法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode node=removeElements(head.next,val);
        if(head.val==val){
            //头节点需要删除
            return node;
        }else{
            //不需要删除头节点
            head.next=node;
            return head;
        }
        //当然我们可以用三行代码解决
//        if(head==null) return null;
//        head.next=removeElements(head.next,val);
//        return head.val==val?head.next:head;
        //实质上二者的执行效率是一样的

    }

}
class _203RemoveLinkedListElements2 {
    /**
     * 直接遍历链表进行删除
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
