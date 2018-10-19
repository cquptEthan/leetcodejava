/*
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (27.16%)
 * Total Accepted:    224K
 * Total Submissions: 824.7K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        int len = nums.length;
        int s = k % len;
        int temp[] = new int[s];

        // 取出最后一串元素
        for (int i = 0; i < s; i++) {
            temp[i] = nums[len - s + i];
        }

        // 移动前一段元素
        for (int i = len - s - 1; i >= 0; i--) {
            nums[s + i] = nums[i];
        }
        for (int i = 0; i < s; i++) {
            nums[i] = temp[i];
        }
    }
}
