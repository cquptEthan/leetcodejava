/*
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (24.45%)
 * Total Accepted:    498.9K
 * Total Submissions: 2M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * 
 */
class Solution {
    public int reverse(int x) {
        String str = String.valueOf(x);
        boolean b = true;
        int limit = -Integer.MAX_VALUE;
        char[] arr;
        if (x < 0) {
            arr = str.substring(1).toCharArray();
            b = false;
            limit = Integer.MIN_VALUE;
        } else {
            arr = str.toCharArray();
        }
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }

        // 借助Long 26ms
        // Long tar = Long.valueOf(new String(arr));
        // if (!b) {
        // tar *= -1;
        // if (tar < Integer.MIN_VALUE) {
        // return 0;
        // } else {
        // return (tar).intValue();
        // }
        // } else {
        // if (tar > Integer.MAX_VALUE) {
        // return 0;
        // } else {
        // return tar.intValue();
        // }
        // }
        int res = 0;
        int len = arr.length;
        int mullimit = limit / 10;
        i = 0;
        while (i < len) {
            int digit = Character.digit(arr[i++], 10);
            if (digit < 0) {
                return 0;
            }
            if (res < mullimit) {
                return 0;
            }
            res *= 10;
            res -= digit;
        }
        return b ? -res : res;
    }
}
