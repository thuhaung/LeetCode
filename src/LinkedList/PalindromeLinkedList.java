package LinkedList;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
//        if (head == null) {
//            return true;
//        }
//
//        List<ListNode> visited = new ArrayList<>();
//
//        while (head != null) {
//            visited.add(head);
//            head = head.next;
//        }
//
//        int left = 0;
//        int right = visited.size() - 1;
//
//        while (left <= right) {
//            if (visited.get(left).val != visited.get(right).val) {
//                return false;
//            }
//
//            left++;
//            right--;
//        }

        ListNode slow, fast;
        slow = fast = head;

        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;

            prev = slow;
            slow = temp;
        }

        ListNode left = head;
        ListNode right = prev;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[3];
        int vals[] = {1, 0, 1};

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(vals[i]);
        }

        for (int i = 0; i < nodes.length; i++) {
            if (i != nodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }

        isPalindrome(nodes[0]);
    }
}
