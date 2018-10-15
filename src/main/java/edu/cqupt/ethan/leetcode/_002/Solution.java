package edu.cqupt.ethan.leetcode._002;

/**
 * @author Ethan
 * @comment
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342+465=807
 * @date 16/3/10
 */
public class Solution {

    /**
     * 4ms  35%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        int flag = 0 ;
        ListNode temp1 = new ListNode(0);
        ListNode temp2 = new ListNode(0);
        temp1.next = l1;
        temp2.next = l2;
        ListNode ret = new ListNode(0);
        ListNode temp3 = ret;
        ListNode temp4;
        while (temp1.next != null || temp2.next != null || flag == 1){
            int i1 = 0;
            int i2 = 0;
            if(temp1.next != null){
                i1 = temp1.next.val;
                temp1 = temp1.next;
            }
            if(temp2.next != null){
                i2 = temp2.next.val;
                temp2 = temp2.next;
            }
            int sum = i1+i2+flag;
            if (sum > 9) {
                sum = (sum)% 10;
                temp4 = new ListNode(sum);
                flag = 1;
            } else {
                temp4 = new ListNode(sum);
                flag = 0;
            }
            temp3.next = temp4;
            temp3 = temp4;
        }
        return ret.next;
    }



    /**
     * 投机取巧不行 有int越界的用例
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode temp1 = new ListNode(0);
        ListNode temp2 = new ListNode(0);
        temp1.next = l1;
        temp2.next = l2;
        int deep1 = 0;
        int deep2 = 0;
        int i1= 0;
        int i2 =0;
        while (temp1.next != null){
           i1+= Math.pow(10,deep1)*temp1.next.val;
            temp1 = temp1.next;
            deep1++;
        }

        while (temp2.next != null){
            i2+= Math.pow(10,deep2)*temp2.next.val;
            temp2 = temp2.next;
            deep2++;
        }

        int i3 = i1+i2;
        if(i3 == 0){
            return new ListNode(0);
        }
        int deep3 = Math.max(deep1,deep2) + 1;
        ListNode node3 = null;
        while (deep3>-1){
            int i10 = Integer.valueOf((int)Math.pow(10, deep3));
            int t = i3/i10;
            i3 -= t*i10;
            if(t > 0 || node3 != null){
                ListNode temp = new ListNode(t);
                temp.next = node3;
                node3 =temp;
            }

            deep3--;
        }
        return node3;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = new ListNode(0);
        ListNode temp2 = new ListNode(0);
        temp1.next = l1;
        temp2.next = l2;
        int flag =0;
        ListNode ret = new ListNode(0);
        ListNode temp3 = ret;
        ListNode temp4;
        while ((temp1 != null || temp2!=null) && (( temp1.next != null || temp2.next!=null ) || flag==1)) {

            if(temp1.next ==null && temp2.next==null){
                temp4 = new ListNode(1);
                temp3.next = temp4;
                temp3 = temp4;
            }else {
                if (temp1.next == null) {
                    int sum = temp2.next.val + flag;
                    if (sum > 9) {
                        sum = (sum)%10;
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                    temp4 = new ListNode(sum);
                    temp3.next = temp4;
                    temp3 = temp4;
                    temp2 = temp2.next;

                } else if (temp2.next == null) {
                    int sum = temp1.next.val + flag;
                    if (sum > 9) {
                        sum = (sum)% 10;
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                    temp4 = new ListNode(sum);
                    temp3.next = temp4;
                    temp3 = temp4;
                    temp1 = temp1.next;
                } else {
                    int sum = temp1.next.val + temp2.next.val +flag;
                    if (sum > 9) {
                        sum = (sum)% 10;
                        temp4 = new ListNode(sum);
                        flag = 1;
                    } else {
                        temp4 = new ListNode(sum);
                        flag = 0;
                    }
                    temp3.next = temp4;
                    temp3 = temp4;
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
            }

        }
        return ret.next;
    }

}
