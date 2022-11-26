import java.util.ArrayList;
import java.util.List;

public class CountingSubArrays {
    
    public int countingSubArrays(ArrayList<Integer> A, int B) {
        int count = 0;
        for (int i = 0; i < A.size(); i++){
            int sum = 0;
            for (int j = i; j < A.size(); j++){
                // range is i to j
               sum += A.get(j); 

               if (sum < B)
                    count+=1;
            }
            
        }
        return count;
    }

    public static void main(String[] args) {
        CountingSubArrays arrays = new CountingSubArrays();
        List<Integer> inp = List.of( 3, 12, 11, 11, 11, 15 );
        int ans  = arrays.countingSubArrays(new ArrayList<>(inp), 12);
        System.out.println(ans);
    }
}
