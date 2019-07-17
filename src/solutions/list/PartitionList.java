package solutions.list;

public class PartitionList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        PartitionList partitionList = new PartitionList();
        ListNode head = partitionList.partition(listNode1, 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private ListNode partition(ListNode head, int x) {
        //将小于x的结点按顺序插入l1，将大于等于x的结点按顺序插入l2
        if (head==null)
            return null;
        ListNode res=head;
        ListNode p1=null;
        ListNode p2=null;
        ListNode h2=null;
        while (head!=null){
            ListNode newNode= new ListNode(head.val);
            if (head.val<x){
                if (p1==null){
                    res=newNode;
                }else {
                    p1.next=newNode;
                }
                p1=newNode;
            }
            else {
                if (p2==null){
                    h2=newNode;
                }else {
                    p2.next=newNode;
                }
                p2=newNode;
            }
            head=head.next;
        }
        //将两个链表连起来
        if (p1!=null)
           p1.next=h2;
        return res;
    }
}
