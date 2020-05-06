package linkedList;

/**
 * 206、反转链表
 */
public class _206ReverseLinkedList {
    /**
     * 递归思路
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
       ListNode newNode=  reverseList(head.next);
       head.next.next=head;
       head.next=null;
       return newNode;

    }
}


 class _206ReverseLinkedList2 {
     /**
      * 常规思路
      * @param head
      * @return
      */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode newNode=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=newNode;
            newNode=head;
            head=temp;
        }
        return newNode;

    }
}

