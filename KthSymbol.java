public class KthSymbol {

    public static int solve(int A, int B) {
        int mid = (int) Math.pow(2, A - 1);
        if (A == 0 || B == 0)
            return 0;

        if (B < mid)
            return solve(A - 1, B);
        else
            return (1 - solve(A - 1, B - mid));
    }

    public static void main(String[] args) {
        int ans = KthSymbol.solve(4, 4);
        System.out.println(ans);
    }
}
