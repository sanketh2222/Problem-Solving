public class SumOddIndices {

    public int[] solve(int[] A, int[][] B) {
        int sumOdd = 0;
        int[] result = new int[B.length];
        int[] prefixOdd = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 1)
                sumOdd += A[i];
            prefixOdd[i] = sumOdd;
            // System.out.print(prefixOdd[i]);

        }

        for (int i = 0; i < B.length; i++) {
            int start = B[i][0];
            int end = B[i][1];
            int querySum = 0;

            if (start == 0) {
                querySum = prefixOdd[end];
            } else {
                querySum = prefixOdd[end] - prefixOdd[start - 1];
            }
            result[i] = querySum;
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 2 }, { 1, 4 } };
        int inpArr[] = { 1, 2, 3, 4, 5};
        SumOddIndices evenIndices = new SumOddIndices();
        int[] ans = evenIndices.solve(inpArr, arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
        int a = 1;
        int b = 1;
        System.out.println(a ^ b);
    }
}
