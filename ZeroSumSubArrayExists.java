import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubArrayExists {

    public int solve(int[] A) {
        Set<Integer> prefixSumHashSet = new HashSet<>();
        int sum = A[0];
        prefixSumHashSet.add(sum);
        for (int i = 1; i < A.length; i++){ 
            if (A[i] == 0)
                return 1;
            sum+=A[i];
            if (!prefixSumHashSet.add(sum)){
                return 1;
            }

        }
        prefixSumHashSet.stream().forEach(System.out::println);
        return prefixSumHashSet.contains(0) ? 1 : 0;
    }
    
    public static void main(String[] args) {
        ZeroSumSubArrayExists zeroSum = new ZeroSumSubArrayExists();
        int[] arr = {1,-1 };
        zeroSum.solve(arr);
        
    }
}
