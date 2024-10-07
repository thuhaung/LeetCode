package LinkedList;

import DataStructure.ListNode;

public class ReverseLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;

            prev = head;
            head = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[5];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(i + 1);
        }

        for (int i = 0; i < nodes.length; i++) {
            if (i != nodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }

        reverseLinkedList(nodes[0]);
    }
}
