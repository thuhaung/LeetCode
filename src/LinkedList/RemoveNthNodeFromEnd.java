package LinkedList;
import DataStructure.ListNode;

public class RemoveNthNodeFromEnd {
    public static ListNode removeNthNode(ListNode head, int n) {
        int j = 0;

        ListNode fast = head;
        ListNode slow = head;

        while (j < n) {
            fast = fast.next;
            j++;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        ListNode x = head;
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[5];
        int[] vals = {1, 2, 3, 4, 5};

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(vals[i]);
        }

        for (int i = 0; i < nodes.length; i++) {
            if (i != nodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }

        removeNthNode(nodes[0], 1);
    }
}
