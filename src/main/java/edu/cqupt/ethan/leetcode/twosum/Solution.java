package edu.cqupt.ethan.leetcode.twosum;

import java.util.HashMap;

/**
 * @author Ethan
 * @comment
 * @date 16/3/10
 */
public class Solution {
//    7ms 44%
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target-nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) != null){
              int j =  map.get(nums[i]);
                if( j != i){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return null;
    }
}
