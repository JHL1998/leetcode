package linkedList;

/**
 * 234、回文链表
 */
public class _234PalindromeLinkedList {
    /**
     * 由于链表不能向数组那样直接设置头尾指针，我们只能将后半段进行反转
     * 本题包含了 找链表的中点、 反转链表等知识点
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
       if(head==null||head.next==null) return true;
        if(head==null||head.next==null) return true;
        //利用快慢指针找中点
        ListNode fast=head;
        ListNode slow=head;

        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //反转slow 即中点后面的链表
        slow=reverse(slow.next);
        while(slow!=null){
            if(head.val!=slow.val) return false;
            head=head.next;
            slow=slow.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode newNode=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
}
