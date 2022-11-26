import java.util.ArrayList;
import java.util.List;

public class SubArraySumLength {


    public int findMaxSubArraySum(ArrayList<Integer> A, int B, int C) {
        int sum = 0;
        for(int i = 0; i < B;i++){
            sum += A.get(i);
        }

        if (sum == C) return 1;

        int start = 1, end = B;//window size 2
        while (end < A.size()){
            sum += A.get(end) - A.get(start - 1);
            if (sum == C)
                return 1;
            start++;
            end++;
        }

        return 0;
    }
    //sliding window
    public static void main(String[] args) {
        SubArraySumLength arraySumLength = new SubArraySumLength();
        List<Integer> inp = List.of( 6);
        int ans = arraySumLength.findMaxSubArraySum(new ArrayList<>(inp), 1, 6);
        System.out.println(ans);
        
    }
}
