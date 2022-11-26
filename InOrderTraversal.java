import java.util.ArrayList;

public class InOrderTraversal {
    private static ArrayList<Integer> ans = new ArrayList<>();
    public static ArrayList<Integer> preorderTraversal(TreeNode A) {

        if (A == null){return null;}
            
        ans.add(A.val);
        preorderTraversal(A.left);
        preorderTraversal(A.right);

        return ans;
    }

    //   private ArrayList<Integer> ans = new ArrayList<>();
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if (A == null)
            return null;
        ans.add(A.left.val);
        inorderTraversal(A);
        inorderTraversal(A.right);
        return ans;
        
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InOrderTraversal.preorderTraversal(root).forEach(System.out::println);
        String str = "sank";
        StringBuffer buffer = new StringBuffer();
        buffer.append(str);
        System.out.println(buffer.reverse());
        
    }
}
