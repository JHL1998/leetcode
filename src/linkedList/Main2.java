package linkedList;

/**
 * 2、两数相加
 */
public class Main2 {
    /**
     * 这个代码比较长，但是很好理解，而且可以复制
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        int carry=0;
      while(l1!=null&&l2!=null){
          int sum=l1.val+l2.val+carry;
          int val=sum%10;
          carry=sum/10;
          ListNode newNode=new ListNode(sum);
          cur.next=newNode;
          cur=cur.next;
          l1=l1.next;
          l2=l2.next;
      }
      while(l1!=null){
          //l2==null
          int sum=l1.val+carry;
          int val=sum%10;
          carry=sum/10;
          cur.next=new ListNode(val);
          cur=cur.next;
          l1=l1.next;
      }
      while(l2!=null){
            //l1==null
            int sum=l2.val+carry;
            int val=sum%10;
            carry=sum/10;
            cur.next=new ListNode(val);
            cur=cur.next;
            l1=l2.next;
        }

        if(carry!=0){
            cur.next=new ListNode(carry);
        }





        return dummy.next;

    }
}

 class _2AddTwoNumbers2 {

     /**
      * 简洁版
      * @param l1
      * @param l2
      * @return
      */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        int carry=0;
        int sum=0;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null) sum=l1.val+l2.val+carry;
            else if(l1!=null) sum=l1.val+carry;
            else sum=l2.val+carry;

            int val=sum%10;
            carry=sum/10;
            cur.next=new ListNode(val);
            cur=cur.next;
            if(l1!=null) l1=l1.next;

            if(l2!=null)  l2=l2.next;

        }
        if(carry!=0){
            cur.next=new ListNode(carry);
        }
        return dummy.next;
    }
}


