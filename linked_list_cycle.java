public class linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null & fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}

/*
Explanation
Make a fast and slow pointer, if there is a cycle at some point they will meet at the cycle

Time: O(n)
Space: O(1)
*/