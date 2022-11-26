public class CountingNodes {
    static int ans = 0;

    public int solve(TreeNode A) {
        return calculateNodes(A.left, A.val);
    }

    private static int calculateNodes(TreeNode A, int rootVal) {
        if (A == null)
            return 0;
        if (A.val > rootVal) {
            ans += 1;
            return ans;
        }

        calculateNodes(A.left, A.val);

        calculateNodes(A.right, A.val);

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        int ans = CountingNodes.calculateNodes(root, root.val);
        System.out.println(ans);

    }
}
