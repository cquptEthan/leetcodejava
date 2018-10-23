/*
 * [142] Linked List Cycle II
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (29.88%)
 * Total Accepted:    174K
 * Total Submissions: 582.3K
 * Testcase Example:  '[]\nno cycle'
 *
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * 
 * 
 * Note: Do not modify the linked list.
 * 
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;

        boolean cycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }

        // slow在相遇点， 将fast置于头结点。 每次移动一步，再次相遇的地方就是环的入口。
        // 
        if (cycle) {
            fast = head;
            while (slow != null) {
                if (fast == slow) {
                    return slow;
                }
                slow = slow.next;
                fast = fast.next;
            }
        }
        return null;
    }
}
