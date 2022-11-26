public class CheckPalindromeWithRecursion {

    public static int solve(String A) {
        char[] arr = A.toCharArray();
        int start = 0, end = arr.length - 1;
        return checkPalindrome(arr, start, end) ? 1 : 0;

    }

    private static boolean checkPalindrome(char[] arr , int start, int end){
        if (start >= end)
            return true;
        if(arr[start] != arr[end])
            return false;
        return checkPalindrome(arr, ++start, --end);
    }

    private static char[] reverseString(char[] arr , int start, int end){
        if (start >= end)
            return arr;
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        return reverseString(arr, ++start, --end);
    }
    
    public static void main(String[] args) {
        String  A = "naman";
        int ans = CheckPalindromeWithRecursion.solve(A);
        System.out.println(ans);
        String str = "hello";
        char[] reverseString = CheckPalindromeWithRecursion.reverseString(str.toCharArray(), 0, str.length() - 1);
        System.out.println(new String(reverseString));
        
    }
}
