import java.util.Map;

import java.util.*;

public class DistinctNumbersInWindow {

    public static int[] dNums(int[] A, int B) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        int index = 0;
        int[] res = new int[A.length - B + 1];
        for (int i = 0; i < B; i++) {
            if (freqMap.containsKey(A[i])) {
                int count = freqMap.get(A[i]);
                freqMap.put(A[i], ++count);
            } else {
                freqMap.put(A[i], 1);
            }

        }
        res[index++] = freqMap.size();
        
        int start = 0, end = B;
        while (start < A.length - B) {
            int count = freqMap.get(A[start]);

            // for start element
            if (count == 1) {
                freqMap.remove(A[start]);
            } else {
                freqMap.put(A[start], --count);
            }

            // for end element
            if (freqMap.containsKey(A[end])) {
                count = freqMap.get(A[end]);
                freqMap.put(A[end], ++count);
            } else {
                freqMap.put(A[end], 1);
            }
            // System.out.println(freqMap.entrySet());
            res[index++] = freqMap.size();
            start++;
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2};
        int B = 1;
        int[] ans = DistinctNumbersInWindow.dNums(arr, B);
        Arrays.stream(ans).forEach(System.out::println);

    }
}
