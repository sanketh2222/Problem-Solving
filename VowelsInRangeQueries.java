public class VowelsInRangeQueries {

    public int[] solve(String A, int[][] B) {
        char[] inpArr = A.toCharArray();
        int vowelCount = 0;
        int[] prefixArr = new int[inpArr.length];
        int[] result = new int[B.length];
        for (int i = 0; i < inpArr.length; i++) {
            if (inpArr[i] == 'a' || inpArr[i] == 'e' || inpArr[i] == 'i' || inpArr[i] == 'o' || inpArr[i] == 'u') {
                vowelCount += 1;
            }
            prefixArr[i] = vowelCount;
        }
        for(int i = 0 ; i < B.length; i++){
            int start = B[i][0];
            int end = B[i][1];
            int querySum = 0;
            if (start == 0){querySum = prefixArr[end];}
            else{querySum = prefixArr[end] - prefixArr[start - 1];}
            result[i] = querySum;
        }
        return result;
    }

    public static void main(String[] args) {
        VowelsInRangeQueries inRangeQueries = new VowelsInRangeQueries();
        String A = "interviewbit";
        int[][] B = { { 0, 4 }, { 9, 10 } };
        inRangeQueries.solve(A, B);

    }
}
