package linkedList;

/**
 * 141、环形链表
 */
public class _141LinkedListCycle {
    /**
     * 采用快慢指针，快指针每次走两步，慢指针每次走一步
     * 如果有环的话，两者速度不同，一定会相遇
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){

        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) return true;
        }
        return false;
    }
}
