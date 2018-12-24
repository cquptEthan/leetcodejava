/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (25.46%)
 * Total Accepted:    660.2K
 * Total Submissions: 2.6M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        char[] strs = s.toCharArray();
        int p = 0;
        int q = 0;
        while (p < strs.length) {
            for (int i = q; i < p; i++) {
                if (strs[i] == strs[p]) {
                    int len = p - q;
                    maxLen = maxLen < len ? len : maxLen;
                    q = i + 1;
                    break;
                }
            }
            p++;
        }
        int len = p - q;
        maxLen = maxLen < len ? len : maxLen;
        return maxLen;
    }
}
