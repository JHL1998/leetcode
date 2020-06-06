package linkedList;

/**
 * 61、旋转链表
 */
public class Main61 {

    public ListNode rotateRight(ListNode head, int k) {
         if(head==null||k==0) return head;
         ListNode cur=head;
         int count=1;
         while(cur.next!=null){
             cur=cur.next;
             count++;
         }

         k=k%count;
         //头尾相连
         cur.next=head;
         for(int i=0;i<count-k;i++){
             cur=cur.next;
         }
         //新的头节点
         ListNode newNode=cur.next;
         //让新的尾节点指向空
         cur.next=null;
         return newNode;
    }

    public void reverseString(char[] s) {


    }
}

