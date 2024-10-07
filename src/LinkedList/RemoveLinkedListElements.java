package LinkedList;

import DataStructure.ListNode;

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = head;

        //       pc  n
        //null -> 1  2   6   3

        while (curr != null) {
            ListNode next = curr.next;

            if (curr.val == val) {
                curr.next = null;
                prev.next = next;
            }
            else {
                prev = curr;
            }

            curr = next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[7];
        int[] vals = {1, 2, 6, 3, 4, 5, 6};

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(vals[i]);
        }

        for (int i = 0; i < nodes.length; i++) {
            if (i != nodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }

        removeElements(nodes[0], 6);
    }
}
