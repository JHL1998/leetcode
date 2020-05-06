package linkedList;

/**
 * 86、分隔链表
 */
public class _86PartitionList {
    public ListNode partition(ListNode head, int x) {
        //如果小于x将它放到dummy1中
        ListNode dummy1=new ListNode(0);
        ListNode cur1=dummy1;
        ListNode dummy2=new ListNode(0);
        ListNode cur2=dummy2;

        while(head!=null){
            if(head.val<x){
                cur1.next=head;
                cur1=cur1.next;

            }
            else if(head.val>=x){
                cur2.next=head;
                cur2=cur2.next;

            }
            head=head.next;
        }
        //将两条链表相连
        cur1.next=dummy2.next;
        cur2.next=null;
        return dummy1.next;

    }
}
