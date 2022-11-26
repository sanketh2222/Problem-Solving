import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrequencyElement {

    public int[] solve(int[] A, int[] B) {
        int[] ans = new int[B.length];
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int i = 0; i < A.length; i++){
            if (freqMap.containsKey(Integer.valueOf(A[i]))){
                int count = freqMap.get(Integer.valueOf(A[i]));
                freqMap.put(A[i],++count);
            }else {
                freqMap.put(A[i],1);
            }
  
        }

        for (int i = 0; i < B.length; i++) {
            if (freqMap.get(Integer.valueOf(B[i])) == null)
                ans[i] = 0;
            else
                ans[i] = freqMap.get(Integer.valueOf(B[i]));
            
        }

        return ans;
    }
    
    public static void main(String[] args) {
        FrequencyElement frequencyElement = new FrequencyElement();
        int[] A = { 7, 6, 6, 3, 1, 5, 7};
        int[] B = { 2, 1, 7, 5, 8};
        //0 1 2 1 0 
        //0 1 1 1 0 
        int[] ans = frequencyElement.solve(A, B);
        Set<Integer> hashSet = new HashSet<>();
        System.out.println(hashSet.add(1));
        System.out.println(hashSet.add(1));
        
    }
}
