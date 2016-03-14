package edu.cqupt.ethan.leetcode.LongestPalindromicSubstring;

/**
 * @author Ethan
 * @comment 最长回文字符串
 * @date 16/3/11
 */
public class Solution {
    public static void main(String[] args){
        String s = "dvfd";
        String ss = "pwwkew";
        String sss = "abba";
        String ssss =  "bbc";
        String sssss =  "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        new Solution().longestPalindrome4(ssss);
    }
    public  String longestPalindrome4(String s){
        if(s.length() == 1){
            return s;
        }

        if (s.length() == 0){
            return "";
        }
        for (int i = s.length() ; i > 0; i--){
            for (int j = 0; j <= s.length() - i; j++) {
                boolean flag = true;
                for (int k = 0; k < i/2; k++) {
                    if( s.charAt(j+k) == s.charAt(i - k +j-1)){

                    }else{
//                        i = j ;
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return s.substring(j,j+i);
                }
            }
        }
        return "";
    }
    public  String longestPalindrome3(String s){

        if(s.length() <= 1){
            return s;
        }

        char[] list = new char[s.length()*2 +1];
        for (int i = 0; i < s.length() ;i++) {
            list[i*2] = '#';
            list[i*2+1] = s.charAt(i);
        }
        list[list.length -1] = '#';

        int[] len = new int[s.length()];
        for (int i = 0, k = 0; i < len.length; i++) {
        }


    return  new String(list);



    }

    /**
     * 超时 158ms
     * @param s
     * @return
     */
    public  String longestPalindrome2(String s){
        if(s.length() == 1){
            return s;
        }

        if (s.length() == 0){
            return "";
        }
        for (int i = s.length() ; i > 0; i--){
                for (int j = 0; j <= s.length() - i; j++) {
                    boolean flag = true;
                    for (int k = 0; k < i/2; k++) {
                        if( s.charAt(j+k) == s.charAt(i - k +j-1)){

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
        return "";
    }

    public String longestPalindrome(String s) {
        String ret = "";
        for (int i = s.length() ; i > 0; i--) {
            if(i%2 == 0){
                for (int j = 0; j <= s.length() - i; j++) {
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
