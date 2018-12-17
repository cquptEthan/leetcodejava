/*
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (43.61%)
 * Total Accepted:    194.4K
 * Total Submissions: 443.3K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /**
     * 非递归实现
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        if (root == null) {
            return ret;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Boolean> s2 = new Stack<Boolean>();
        while (!stack.empty() || p != null) {
            while (p != null) {
                stack.push(p);
                s2.push(false);
                p = p.left;
            }

            while (!stack.empty() && s2.peek()) {
                s2.pop();
                TreeNode top = stack.peek();
                if (top.left == null && top.right == null) {
                    List<String> strs = new ArrayList<String>();
                    List<TreeNode> list = stack.subList(0, stack.size());
                    for (int i = 0; i < list.size(); i++) {
                        strs.add(String.valueOf(list.get(i).val));
                    }
                    ret.add(String.join("->", strs));
                }
                stack.pop();
            }

            if (!stack.empty()) {
                s2.pop();
                s2.push(true);
                p = stack.peek().right;
            }
        }
        return ret;
    }
}
