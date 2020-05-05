package sort;

/**
 * 147、对链表进行插入排序
 */
public class _147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode temp = null;
        while (cur.next != null && cur != null) {
            if (cur.val <= cur.next.val) {
                //有序的
                cur = cur.next;
            } else {
                //保存cur.next
                temp = cur.next;
                //删除cur.next
                cur.next = cur.next.next;
                //重置pre
                pre = dummy;
                //将存储的temp往前插入
                while (pre.next.val <= temp.val) {
                    //有序
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dummy.next;

    }
}
