public class XorSum {

    public int solve(int A, int B) {
        int result = 0,ans = Integer.MAX_VALUE;
        for (int i = 0 ; i < 50 ; i ++){
                result = (A ^ i) + (B ^ i);
                if (result < ans)
                    ans = result;
        }

        return ans;

    }

    public static void main(String[] args) {
        XorSum xorSum = new XorSum();
       int ans = xorSum.solve(20, 20);
       System.out.println(ans);
        // int result = (20 ^ 0) + (20 ^ 0);
        // System.out.println(20 ^ 20);
    }
}
