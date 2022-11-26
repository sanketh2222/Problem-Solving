import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountUniqueElements {

    public int solve(int[] A) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (freqMap.containsKey(A[i])) {
                int count = freqMap.get(A[i]);
                freqMap.put(A[i], ++count);
            } else {
                freqMap.put(A[i], 1);
            }
        }
        return (int) freqMap.values().stream().filter(x -> x == 1).count();
    }

    public static void main(String[] args) {
        CountUniqueElements countUniqueElements = new CountUniqueElements();
        int[] arr = { 3, 3, 3, 9, 0, 1, 0 };
        int ans = countUniqueElements.solve(arr);
        System.out.println(ans);
        Set<Integer> uniqueElements = new HashSet<>();
        uniqueElements.forEach(System.out::println);
        // Iterator<Integer> it = new Iterable() {
            
        // };
        
    }
}
