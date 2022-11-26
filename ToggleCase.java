public class ToggleCase {

    public String solve(String A) {
        char[] arr = A.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] ^=32;
        }
        return new String(arr);
    }
    
    public static void main(String[] args) {
        String A = "Hello";
        ToggleCase toggleCase = new ToggleCase();
        String ans  = toggleCase.solve(A);
        System.out.println(ans);
    }
}
