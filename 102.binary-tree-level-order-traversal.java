import java.util.ArrayList;
import java.util.LinkedList;

/*
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (45.04%)
 * Total Accepted:    288.1K
 * Total Submissions: 639.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
        tns.add(root);
        while (tns.size() != 0) {
            List<Integer> curLevel = new LinkedList<>();
            // 确定要当前层数的元素个数
            int size = tns.size();
            for (int i = 0; i < size; i++) {
                // 使用poll方法，保证就在一个数组中操作就可以了
                TreeNode node = tns.poll();
                if (node != null) {
                    curLevel.add(node.val);
                    if (node.left != null) {
                        tns.add(node.left);
                    }
                    if (node.right != null) {
                        tns.add(node.right);
                    }
                }
            }
            ret.add(curLevel);
        }
        return ret;
    }
}
