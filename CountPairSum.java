import java.util.HashMap;
import java.util.Map;


public class CountPairSum {

    public static int solve(int[] A, int B) {
        Map<Integer, Long> hashMap = new HashMap<>();
        long count = 0, ans = 0;
        long M = 1000000007;
        // Iterator<Integer> it = hashMap.iterator();
        // while(it.hasNext()){
        // if (hashSet.contains(B - it.next()))
        // count+=1;
        // else
        // hashSet.add(it.next());
        // }

        for (int i = 0; i < A.length; i++) {
            if (hashMap.containsKey(B - A[i])) {
                count = hashMap.get(B - A[i]);
                ans += count;
                addElementToHashMap(A, hashMap, count, i);
            } else {
                count = addElementToHashMap(A, hashMap, count, i);
            }

        }

        return (int) (ans % M);
    }

    private static long addElementToHashMap(int[] A, Map<Integer, Long> hashMap, long count, int i) {
        if (hashMap.containsKey(A[i])) {
            count = hashMap.get(A[i]);
            hashMap.put(A[i], ++count);
        } else {
            hashMap.put(A[i], 1L);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 2 };
        int ans = CountPairSum.solve(arr, 3);
        System.out.println(ans);

    }
}
