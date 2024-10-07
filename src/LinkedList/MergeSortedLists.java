package LinkedList;

import DataStructure.ListNode;

public class MergeSortedLists {
    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode();
        ListNode curr = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        }
        else {
            curr.next = list2;
        }

        return head.next;
    }

    public static void main(String[] args) {

    }
}
