public class Merge_Two_Sorted_Lists_21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 == null) {
            dummy.next = l2;
        } else {
            dummy.next = l1;
        }
        return head.next;
    }
}

/*
 * Also appears on AlgoExpert, Leetcode75
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Explanation
 * 
 * We use a dummy node, and which value is smaller, we take it and point it to
 * the dummy node
 * 1->2->4
 * 1->3->4->5->6
 * if we exhaust a list, another list can have still have some values after it,
 * in that case, we just point our dummy.next to l2, and vice versa
 * 
 * Time: O(n + m)
 * Space: O(1)
 * 
 * Write the test case in LinkedListTests.java
 */