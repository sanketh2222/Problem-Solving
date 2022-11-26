public class SubArrayBitwiseSum {

    public long solve(int A, int[] B) {

        long result = 0;
        long zeroSubArrayCount = 0;
        long totalSubArray = (B.length) * (B.length + 1) / 2;
        for (int i = 0; i < B.length; i++) {
            if (i == B.length - 1 || B[i] == 1) {
                if (B[i] == 0) {
                    zeroSubArrayCount += 1;
                }
                result += zeroSubArrayCount * (zeroSubArrayCount + 1) / 2;
                zeroSubArrayCount = 0;
            } else if (B[i] == 0) {
                zeroSubArrayCount += 1;
            }
        }

        return (totalSubArray - result);
    }

    public static void main(String[] args) {
        SubArrayBitwiseSum sum = new SubArrayBitwiseSum();
        int[] inp = { 1,1,1,1,1,1,1,1,1,1,1};
        long ans = sum.solve(inp.length, inp);
        System.out.println(ans);
    }
}
