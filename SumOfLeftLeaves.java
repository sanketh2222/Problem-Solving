public class SumOfLeftLeaves {

    static int ans = 0;
    static boolean isrightNode = false;
    public static int solve(TreeNode A) {
        int res = findSumOfLeftLeafNode(A,true);
        return res;
    }

    private static int findSumOfLeftLeafNode(TreeNode A,Boolean isrightNode){
        
        if (A == null)
            return 0;

        if (A.left == null && A.right == null && !isrightNode) {
            return ans += A.val;
        }

        if (A.left != null){
            findSumOfLeftLeafNode(A.left,false);
        }

        if (A.right != null){
            findSumOfLeftLeafNode(A.right,true);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(-1);
        // root.right.right = new TreeNode(7);
        int ans = SumOfLeftLeaves.solve(root);
        System.out.println(ans);

    }
}
