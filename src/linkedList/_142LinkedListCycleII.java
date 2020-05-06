package linkedList;

/**
 * 142、环形链表2
 */
public class _142LinkedListCycleII {
    /**
     * 这题在141的基础之上，我们先判断有没有环
     * 我们假设环的长度为m+n,并且快慢指针在相遇的位置为m.假设头节点到环开始的距离为a。
     * 那么慢指针此时应该走了a+m。快指针走了a+n+2m，并且二者的速度分别为v和2v，
     * 且在相等的时间内，这时候我们就可以列出一个等式.
     * (a+m)/v=(a+2m+n)/2v.  通过这个等式，我们求的a=n.这是一个非常有用的信息.
     * 此时我们让一个新的节点从头节点开始走，然后让慢指针继续走，当二者相遇时，就是环的位置
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                //有环
                ListNode temp=head;
                while(slow!=temp){
                    temp=temp.next;
                    slow=slow.next;
                    //二者相遇，temp所在位置就是环的位置

                }
                return temp;
            }
        }
        return null;
    }
}
