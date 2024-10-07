package LinkedList;

import DataStructure.ListNode;

public class RemoveDuplicatesFromSortedList {
    public static ListNode removeDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.next.val == curr.val) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[5];
        int vals[] = {1, 1, 2, 3, 3};

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(vals[i]);
        }

        for (int i = 0; i < nodes.length; i++) {
            if (i != nodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }

        removeDuplicates(nodes[0]);
    }
}
