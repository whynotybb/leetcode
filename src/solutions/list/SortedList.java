package solutions.list;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortedList {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node3=new ListNode(3);
        ListNode node5=new ListNode(5);
        ListNode node2=new ListNode(2);
        ListNode node4=new ListNode(4);
        ListNode node6=new ListNode(6);
        node1.next=node3;
        node3.next=node5;
        node5.next=node2;
        node2.next=node4;
        node4.next=node6;
        SortedList sortedList=new SortedList();
        ListNode head= sortedList.sortList(node1);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    private ListNode sortList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        //findMiddle node
        ListNode middle=findMiddle(head);
        ListNode rightH=  sortList(middle.next);
        middle.next=null;
        ListNode leftH= sortList(head);
        return merge(leftH,rightH);
    }
    //寻找链表的中间结点
    private ListNode findMiddle(ListNode head){
        ListNode p=head.next;
        ListNode q=head;
        while (p!=null&&p.next!=null){
            p=p.next.next;
            q=q.next;
        }
        return q;
    }
    //将两个有序链表合二为一,返回合并后头结点
    private ListNode merge(ListNode p,ListNode q){
        ListNode head=null;
        ListNode c=null;
        while (p!=null&&q!=null){
            if (p.val<q.val){
                if (head==null){
                    head=p;
                }else {
                    c.next=p;
                }
                c=p;
                p=p.next;
            }else {
                if (head==null){
                    head=q;
                }else {
                    c.next=q;
                }
                c=q;
                q=q.next;
            }
        }
        //处理剩余
        if (p!=null&&c!=null){
            c.next=p;
        }
       if (q!=null&&c!=null){
            c.next=q;
        }
        return head;
    }
}
