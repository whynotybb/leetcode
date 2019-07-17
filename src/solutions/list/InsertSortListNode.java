package solutions.list;

/**
 * Sort a linked list using insertion sort.
 */
public class InsertSortListNode {
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

        InsertSortListNode insertSortListNode=new InsertSortListNode();
        ListNode head= insertSortListNode.insertionSortList(node1);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    /**
     * 新建一个链表，遍历原链表，逐个插入
     */
    private ListNode insertionSortList(ListNode head) {
        if (head==null)
            return null;
        ListNode p=head.next;
        ListNode res =new ListNode(head.val);//新链表
        ListNode lastOfQ=null;
        while (p!=null){
            //寻找新结点应插入的位置
            ListNode q=res;
            while (q!=null&&q.val<p.val){
                lastOfQ=q;
                q=q.next;
            }
            ListNode newNode=new ListNode(p.val);
            //将p插入到q前
            if (q==res){
                res=newNode;
                newNode.next=q;
            }
            else if (q==null){
                lastOfQ.next=newNode;
            }
            else {
                //中间
                lastOfQ.next=newNode;
                newNode.next=q;
            }
            p=p.next;
        }
        return res;
    }
}
