package dfs;

/**
 * 104. Maximum Depth of Binary Tree https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Level: easy
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaxDepthBinaryTree104Easy {

    int maxDepth;

    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return maxDepth;
    }

    public void dfs(TreeNode node,int depth) {
        if (node == null) {
            return;
        }

        depth = depth + 1;

        if (depth > maxDepth) {
            maxDepth = depth;
        }

        dfs(node.left,depth);
        dfs(node.right,depth);

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
