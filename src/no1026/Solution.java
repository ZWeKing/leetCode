package no1026;
/**
Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

        (A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)



        Example 1:



        Input: [8,3,10,1,6,null,14,null,null,4,7,13]
        Output: 7
        Explanation:
        We have various ancestor-node differences, some of which are given below :
        |8 - 3| = 5
        |3 - 7| = 4
        |8 - 1| = 7
        |10 - 13| = 3
        Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
**/
public class Solution {

    int diff = 0;

    public int maxAncestorDiff (TreeNode root) {

        dfs(root,root.val,root.val);

        return diff;
    }

    /**
     * 深度遍历每一个节点，记录该节点中所有父节点中的最大值和最小值，计算节点值与父节点最大值和最小值的差值，更新diff。
     * @param node
     * @param max
     * @param min
     */
    public void dfs(TreeNode node, int max, int min){
        if (node == null) {
            return;
        }

        int maxDiff = Math.abs(max - node.val);
        int minDiff = Math.abs(min - node.val);

        diff = Math.max(diff,Math.max(maxDiff,minDiff));

        max = Math.max(node.val,max);
        min = Math.min(node.val,min);

        dfs(node.left,max,min);
        dfs(node.right,max,min);

    }

    public static void main (String[] args) {

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
