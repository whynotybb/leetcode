package solutions.list;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next=node3;
        DetectCycle detectCycle=new DetectCycle();
        ListNode listNode= detectCycle.detectCycle(node1);
        System.out.println(listNode.val);
    }

    private ListNode detectCycle(ListNode head) {
        ListNode p = head;
        if (head == null)
            return null;
        ListNode q = head.next;
        while (q != null && q.next != null) {
            if (p == q) {
                //说明有环
                //1，求环包含的结点数
                int countNode = 1;
                p=p.next;
                while (p != q) {
                    countNode++;
                    p = p.next;
                }
                //2,求环的入口结点
                p = head;
                q = head;
                while (countNode != 0) {
                    p = p.next;
                    countNode--;
                }
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
            p = p.next;
            q = q.next.next;
        }
        return null;
    }
    public boolean havingCycle(ListNode head){
        if (head==null)
            return false;
        ListNode p=head;
        ListNode q=head.next;
        while (q!=null&&q.next!=null){
            if (p==q){
                return true;
            }
            p=p.next;
            q=q.next.next;
        }
        return false;
    }
}
