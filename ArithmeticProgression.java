import java.util.Arrays;

public class ArithmeticProgression {

    public int solve(int[] A) {

        boolean isAp = true;
        Arrays.sort(A);
        int prevEle = A[1], firstDiff = A[1] - A[0];
        for (int i = 2 ; i < A.length; i++){
            int cDiff = A[i] - prevEle;
            prevEle = A[i];
            if (cDiff != firstDiff){
                isAp = false;
                break;
            }
        }

        return isAp ? 1 : 0;
    }
    
    public static void main(String[] args) {
        ArithmeticProgression arithmeticProgression = new ArithmeticProgression();
        int arr[] = {3,5,1};
        int ans = arithmeticProgression.solve(arr);
        System.out.println(ans);
    }
}
