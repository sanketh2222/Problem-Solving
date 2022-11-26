import java.util.ArrayList;
import java.util.List;

public class LeastAvgSubArray {
    
    public int leastAvgSubArray(ArrayList<Integer> A, int B) {
        int sum = 0;
        for (int i = 0; i < B; i++){
            sum +=A.get(i);
        }
    
        double ans = sum;
        int value = 0;
        int start = 1, end = B;

        while ( end < A.size()){
            sum+= (A.get(end) - A.get(start - 1));

            if (sum < ans){
                ans = sum;
                value = start;
            }

            start++;
            end++;
        }

        return value;

    }

    public static void main(String[] args) {
        LeastAvgSubArray array = new LeastAvgSubArray();
        List<Integer> inp =  List.of(5, 15, 7, 6, 3, 4, 18, 14, 13, 7, 3, 7, 2, 18 );
        int ans = array.leastAvgSubArray(new ArrayList<>(inp), 6);
        System.out.println(ans);
        
    }
}
