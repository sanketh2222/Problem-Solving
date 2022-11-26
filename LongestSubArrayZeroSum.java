public class LongestSubArrayZeroSum {
    
    public static int solve(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++){
            int sum = A[i];
           for (int j = i + 1; j < A.length; j++) {
                sum += (A[j]);

                if (sum == 0)
                    ans = Math.max(ans, j - i + 1);
           }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {9, -20, -11, -8, -4, 2, -12, 14, 1};
        int ans = LongestSubArrayZeroSum.solve(arr);
        System.out.println(ans);
    }
}
