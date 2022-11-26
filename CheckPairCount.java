import java.util.HashSet;
import java.util.Set;

public class CheckPairCount {

    public int solve(int A, int[] B) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < B.length; i++){
            if (hashSet.contains(A - B[i]))
                return 1;
            else 
                hashSet.add(B[i]);
        }

        return 0;
    }
    
    public static void main(String[] args) {
        
    }
}
