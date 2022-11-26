import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public static int solve(int[] A, int B) {
        int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        // for (int i = 0; i < A.length; i++){
        // int sum = 0;
        // for (int j = i; j < A.length; j++ ){
        // sum += A[j];
        // if (sum == B)
        // count +=1;
        // }
        // }
        hashMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (hashMap.containsKey(sum - B)) {
                count += 1;
            } else {
                hashMap.put(sum, i);
            }
        }
        // System.out.println(hashMap.getOrDefault(100, 0));
        return count;
    }

    //2 POINTER APPROACH

    public static void main(String[] args) {
        int[] arr = { 1,1,2,2 };
        int ans = SubArraySumEqualsK.solve(arr, 3);
        System.out.println(ans);

    }
}
