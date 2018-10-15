package edu.cqupt.ethan.leetcode._002;

/** 749 + 74
 * @author Ethan
 * @comment
 * @date 16/3/10
 */
public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);
        ListNode d = new ListNode(9);
        ListNode e = new ListNode(9);
        ListNode f = new ListNode(9);
        ListNode g = new ListNode(9);
        ListNode h = new ListNode(9);
        ListNode i = new ListNode(9);
        ListNode j = new ListNode(9);
        ListNode k = new ListNode(9);
        ListNode l = new ListNode(1);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        g.next=h;
        h.next=i;
        i.next=j;
        j.next=k;
//        b.next=c;
//        b.next=d;
        Solution s = new Solution();
        s.addTwoNumbers3(a, l);
    }

}
