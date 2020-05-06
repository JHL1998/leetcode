package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 160、相交链表
 */
public class _160IntersectionOfTwoLinkedLists {

    // A->B->C->D->E
    //X->Y->Z->C->D->E
    //即此时相交的点为C

    /**
     * 我们采取这样一种思路
     * A->B->C->D->E->X->Y->Z->C->D->E
     * X->Y->Z->C->D->E->A->B->C->D->E
     * 此时我们可以求出来C为相交点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;

        while(curA!=curB){
            curA = (curA == null) ? headB : curA.next;
            curB = (curB== null) ? headA : curB.next;
            //如果两个链表没有相交的话，会陷入死循环
            //curA=(curA.next==null)?headB:curA.next;
            //curB=(curB.next==null)?headA:curB.next;
        }
        return curA;


    }
}


 class _160IntersectionOfTwoLinkedLists2 {

     /**
      * 利用set
      * @param headA
      * @param headB
      * @return
      */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        Set<ListNode> set=new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){

            if(set.contains(headB)) return headB;
            headB=headB.next;
        }
        return null;


    }
}
