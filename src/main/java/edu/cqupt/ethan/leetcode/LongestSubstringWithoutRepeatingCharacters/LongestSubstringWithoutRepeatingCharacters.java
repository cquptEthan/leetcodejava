package edu.cqupt.ethan.leetcode.LongestSubstringWithoutRepeatingCharacters;

import edu.cqupt.ethan.leetcode.AddTwoNumbers.ListNode;

import java.util.HashMap;

/**
 * @author Ethan
 * @comment
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * @date 16/3/11
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        String s = "dvfd";
        String ss = "pwwkew";
        String sss = "abba";
        String ssss =  "aa";
        String sssss =  "wsslpluuwekuaxt";
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring3(sssss);
    }
    public int lengthOfLongestSubstring4(String s) {
        int[][] list = new int[255][2];
        int lenth = 0;
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if(list[ch][0] == 0){
                list[ch][0] = 1;
                lenth++;
            }else{
                if(maxLen < lenth){
                    maxLen = lenth;
                }
                if(start <= list[ch][1]) {
                    lenth -= list[ch][1] - start;
                    start= list[ch][1] + 1;
                }else{
                    lenth ++;
                }
            }
            list[ch][1] = i;
        }
        if(maxLen < lenth){
            maxLen =lenth;
        }
        return maxLen;
    }

    /**
     * 16ms 64%
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int[][] list = new int[255][2];
        int lenth = 0;
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if(list[ch][0] == 0){
                list[ch][0] = 1;
                lenth++;
            }else{
                if(maxLen < lenth){
                    maxLen = lenth;
                }
                //判断重复的是否在当前字符串之后
                if(start <= list[ch][1]) {
                    lenth -= list[ch][1] - start;
                    start= list[ch][1] + 1;
                }else{
                    lenth ++;
                }
            }
            list[ch][1] = i;
        }
        if(maxLen < lenth){
            maxLen =lenth;
        }
        return maxLen;
    }


    /**
     * 链表不方便实现
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int max=0;
        if(s.length() == 0){
            return 0;
        }else {

            ListNode head = new ListNode(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                ListNode temp = head;

                char curchar = s.charAt(i);
                ListNode curNode = new ListNode(curchar);
                while (temp.next != null){
                    temp = temp.next;


                }
                temp.next = curNode;
                ListNode temp2 = head;
                while (temp2.next != null){
                    if (temp2.val == curchar){
                        int cur = countList(head);
                        if(max < cur){
                            max = cur;
                        }
                        head = temp2.next;
                    }
                    temp2 = temp2.next;
                }
            }
            int cur = countList(head);
            if(max < cur){
                max = cur;
            }
        }
        return max;
    }

    public int countList(ListNode l){
        int sum = 0;
        while (l != null) {
            sum++;
            l = l.next;
        }
        return sum;
    }
    class ListNode {
        char val;
        ListNode next;
        ListNode(char x) { val = x; }
    }
    /**
     * 15 57MS
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int maxLenth = 0;
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i,i+1);
            if( sb.indexOf(temp) == -1){
                sb.append(temp);
            }else{
                if(maxLenth < sb.length()) {
                    maxLenth = sb.length();
                    System.out.println(sb);
                }
                sb.delete(0,sb.indexOf(temp)+1);
                sb.append(temp);
            }
        }
        if(maxLenth < sb.length()) {
            maxLenth = sb.length();
        }
                return maxLenth;
    }
}
