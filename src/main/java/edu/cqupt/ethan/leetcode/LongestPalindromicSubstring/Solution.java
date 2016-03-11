package edu.cqupt.ethan.leetcode.LongestPalindromicSubstring;

/**
 * @author Ethan
 * @comment
 * @date 16/3/11
 */
public class Solution {
    public static void main(String[] args){
        String s = "dvfd";
        String ss = "pwwkew";
        String sss = "abba";
        String ssss =  "aa";
        String sssss =  "aa";
        new Solution().longestPalindrome(sssss);
    }
    public String longestPalindrome(String s) {
        String ret = "";
        for (int i = s.length() ; i > 0; i--) {
            if(i%2 == 0){
                for (int j = 0; j < s.length() - i; j++) {
                    boolean flag = true;
                    for (int k = j; k < i/2; k++) {
                      if( s.charAt(k) == s.charAt(i-k)){

                      }else{
                          flag = false;
                      }
                    }
                    if(flag){
                        return s.substring(j,j+i);
                    }
                }
            }else{

                for (int j = 0; j <= s.length() - i; j++) {
                    boolean flag = true;
                    for (int k = j; k < i/2-1; k++) {
                        if( s.charAt(k) == s.charAt(i-k)){

                        }else{
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        return s.substring(j,j+i);
                    }
                }
            }
        }
        return ret;
    }
}
