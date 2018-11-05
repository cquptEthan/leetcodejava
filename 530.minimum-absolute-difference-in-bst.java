/*
 * [530] Minimum Absolute Difference in BST
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (48.66%)
 * Total Accepted:    47K
 * Total Submissions: 96.7K
 * Testcase Example:  '[1,null,3,2]'
 *
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and
 * 1 (or between 2 and 3).
 * 
 * 
 * 
 * 
 * Note: There are at least two nodes in this BST.
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        int next = 0;
        TreeNode node = root;
        // 左节点
        if (root.left != null) {
            node = root.left;
            // 找左节点最深的右节点，差值跟根节点是最小的
            while (node.right != null) {
                node = node.right;
            }
            int diff = root.val - node.val;
            min = diff < min ? diff : min;
            next = getMinimumDifference(root.left);
            min = next < min ? next : min;
        }

        if (root.right != null) {
            node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            int diff = node.val - root.val;
            min = diff < min ? diff : min;
            next = getMinimumDifference(root.right);
            min = next < min ? next : min;
        }
        return min;
    }
}
