package Tree.Easy;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumOfRootToLeafBinary {

    static int dfs(TreeNode root, int binarySum) {
        if(root == null) {
            return 0;
        }
        binarySum = 2*binarySum + root.val;
        if(root.left == null && root.right == null) {
            return binarySum;
        }
        return dfs(root.left, binarySum) + dfs(root.right, binarySum);
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
}