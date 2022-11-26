public class SumOfEvenIndices {

    public int[] solve(int[] A, int[][] B) {
        int[] evenPrefix = new int[A.length];
        int[] result = new int[B.length];
        int sum = A[0];
        evenPrefix[0]= A[0]; 
        for (int i = 1; i < A.length; i++) {
            if ( i % 2 == 0)
                sum += A[i];
            
            evenPrefix[i] = sum;
        }

        for (int i = 0; i < B.length; i++) {
            int start = B[i][0];
            int end = B[i][1];
            int querySum = 0;
            if (start == 0){
                querySum = evenPrefix[end];
            }else{
                querySum = evenPrefix[end] - evenPrefix[start - 1];
            }
            result[i] = querySum;
            
        }
        return result;
    }


    public static void main(String[] args) {
        int arr[][] = { { 0, 3 }, { 2, 4 } };
        int inpArr[] = {2, 1, 8, 3, 9};
        SumOfEvenIndices evenIndices = new SumOfEvenIndices();
        int[] ans = evenIndices.solve(inpArr, arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
        // printMatrix(arr);

    }


    private static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
