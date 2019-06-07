package tree;

/**
 *654. Maximum Binary Tree https://leetcode.com/problems/maximum-binary-tree/
 * Medium
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * Note:
 * The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree654Medium {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums.length == 0) {
            return null;
        }

        int index = findMaxValueIndex(nums,0,nums.length-1);

        TreeNode rootNode = new TreeNode(nums[index]);

        constructBinaryRecursive(rootNode, nums, 0, index-1, true);
        constructBinaryRecursive(rootNode, nums, index+1, nums.length-1, false);

        return rootNode;

    }


    public void constructBinaryRecursive(TreeNode rootNode, int[] nums, int start, int end, boolean isLeft) {

        if (start > end) {
            return;
        }

        int index = findMaxValueIndex(nums,start,end);

        TreeNode node = new TreeNode(nums[index]);

        if (isLeft)
            rootNode.left = node;
        else
            rootNode.right = node;

        constructBinaryRecursive(node,nums,start,index-1,true);
        constructBinaryRecursive(node,nums,index+1,end,false);
    }


    public int findMaxValueIndex(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }

        int index = start, maxValue = nums[start];

        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }

        return index;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}