package Jan_2021;

public class Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {

    private TreeNode findClonedTarget(final TreeNode root, final TreeNode cloned, final TreeNode target) {
        if (root == null) return null;
        TreeNode left = findClonedTarget(root.left, cloned.left, target);
        if (root == target) {
            return cloned;
        }
        return (left != null ? left : findClonedTarget(root.right, cloned.right, target));
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return findClonedTarget(original, cloned, target);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
