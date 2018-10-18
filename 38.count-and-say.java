/*
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (38.03%)
 * Total Accepted:    226.1K
 * Total Submissions: 594.5K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the
 * count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "1211"
 * 
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String read = countAndSay(n - 1);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int count = 1;
        while ((i + 1) < read.length()) {
            char c = read.charAt(i);
            i++;
            if (c == read.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(read.charAt(read.length() - 1));
        return sb.toString();
    }
}
