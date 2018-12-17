/*
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (41.69%)
 * Total Accepted:    319.6K
 * Total Submissions: 764K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3]  is not:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /**
     * 求中序遍历数组，检查数字前后元素。 此方法有误.
     */
    // public boolean isSymmetric(TreeNode root) {
    // List<Integer> mid = new ArrayList<Integer>();

    // Stack<TreeNode> stack = new Stack<TreeNode>();
    // TreeNode p = root;

    // while (!stack.isEmpty() || p != null) {
    // while (p != null) {
    // stack.push(p);
    // p = p.left;
    // }
    // TreeNode top = stack.pop();
    // if (top.left == null && top.right != null) {
    // mid.add(null);
    // }
    // mid.add(top.val);
    // if (top.right == null && top.left != null) {
    // mid.add(null);
    // }
    // p = top.right;
    // }

    // for (int i = 0; i < mid.size() / 2; i++) {
    // if (mid.get(i) != mid.get(mid.size() - 1 - i)) {
    // return false;
    // }
    // }
    // return true;
    // }

    /**
     * 递归比较
     */
    // public boolean isSymmetric(TreeNode root) {
    // if (root == null) {
    // return true;
    // }
    // return compare(root.left, root.right);
    // }

    // public boolean compare(TreeNode left, TreeNode right) {
    // if (left == null && right == null) {
    // return true;
    // }
    // if ((left != null) && right != null) {
    // if (left.val != right.val) {
    // return false;
    // }
    // return compare(left.left, right.right) && compare(left.right, right.left);
    // }
    // return false;
    // }

    /**
     * 非递归版本
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(p.left);
        stack.push(p.right);
        while (!stack.empty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (right != null && left != null) {
                if (right.val != left.val) {
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
                stack.push(left.right);
                stack.push(right.left);
            }
            if ((right != null && left == null) || (left != null && right == null)) {
                return false;
            }
        }
        return true;
    }

}
