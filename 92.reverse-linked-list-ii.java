/*
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (32.71%)
 * Total Accepted:    158.9K
 * Total Submissions: 485.8K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 1->3->2->4->5
 * 1->4->3->2->5
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 如果头结点参与了旋转，需要增加一个不会旋转的傀儡头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curp = dummyHead;
        // 开始旋转前一个点
        ListNode root = head;
        // 前一个节点
        ListNode prevNode = null;

        int index = 0;
        while (curp != null) {
            if ((index + 1) == m) {
                root = curp;
            }
            if (index == m) {
                prevNode = curp;
            }
            if (index > m && index <= n) {
                prevNode.next = curp.next;
                curp.next = root.next;
                root.next = curp;
                curp = prevNode;
            }
            curp = curp.next;
            index++;
        }
        return dummyHead.next;
    }
}
