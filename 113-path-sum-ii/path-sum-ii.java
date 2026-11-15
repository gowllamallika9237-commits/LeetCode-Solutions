/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), paths);
        return paths;
    }

    private void findPaths(TreeNode node, int remaining,
                           List<Integer> path, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        remaining -= node.val;

        if (node.left == null && node.right == null && remaining == 0) {
            paths.add(new ArrayList<>(path));
        } else {
            findPaths(node.left, remaining, path, paths);
            findPaths(node.right, remaining, path, paths);
        }

        path.remove(path.size() - 1);
    }
}