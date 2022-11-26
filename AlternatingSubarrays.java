import java.util.ArrayList;
import java.util.List;

public class AlternatingSubarrays {

    public int[] solve(int[] A, int B) {
        int length = 2 * B + 1;
        List<Integer> finalList = new ArrayList<>();
        int end = 0;
        boolean isAlernating = true;
        for (int i = 0; i < A.length - length; i++) {
            int start = i;
            int j = start;
            isAlernating = true;
            while (j < (i + length - 1)) {
                if (A[j] == A[j + 1]) {
                    isAlernating = false;
                    break;
                } else {
                    end = j + 1;
                }
                j++;
            }
            if (length == 1) {
                end++;
            }
            if (isAlernating) {
                finalList.add((start + end) / 2);
            }

        }
        return finalList.stream().mapToInt(i -> i).toArray();
        // return result;
    }

    public static void main(String[] args) {
        AlternatingSubarrays alternatingSubarrays = new AlternatingSubarrays();
        int[] arr = { 1, 1, 1, 1, 1, 0, 1 };
        int[] ans = alternatingSubarrays.solve(arr, 0);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
    }
}
