/*
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (32.01%)
 * Total Accepted:    336.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int prefix = 0;
        int maxLen = Integer.MAX_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();
            if (maxLen > len) {
                maxLen = len;
                maxIndex = i;
            }
        }
        while (prefix < maxLen) {
            char cur = strs[maxIndex].charAt(prefix);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(prefix) != cur) {
                    return strs[maxIndex].substring(0, prefix);
                }
            }
            prefix++;
        }

        return strs[maxIndex].substring(0, prefix);
    }
}
