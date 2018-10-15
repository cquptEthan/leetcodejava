package edu.cqupt.ethan.leetcode._026;

/**
 * Solution
 * Description:
 * User: ethan
 * Date: 2018-10-15
 * Time: 下午4:40
 */
public class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0){
                return 0;
            }

            int curNum = nums[0];
            int count = 1;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != curNum){
                    curNum = nums[i];
                    nums[count] = nums[i];
                    count++;
                }
            }
            return count;
        }
}
