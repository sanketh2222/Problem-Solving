import java.util.ArrayList;
import java.util.List;

public class PickFromBothSides {

    public int solve(ArrayList<Integer> A, int B) {

        int[] prefix = new int[A.size()];
        // build prefix
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            prefix[i] = sum;
        }

        int start = 0, end = B;
        int result = Integer.MIN_VALUE, ans = 0;
        while (start <= B && end >= 0) {

            if (end == 0) {// all left side elements
                ans = prefix[start - 1];
            } else if (start == 0 && (prefix[A.size() - 1 - end]) >= 0) {// pick all elements from the right
                ans = prefix[A.size() - 1] - prefix[A.size() - 1 - end];
            } else if (start == 0) {
                ans = prefix[A.size() - 1];
            } else {// both from left side and right side
                ans = prefix[start - 1] + (prefix[A.size() - 1] - prefix[A.size() - 1 - end]);
            }
            if (ans > result)
                result = ans;
            end--;
            start++;
        }

        return result;

    }

    public static void main(String[] args) {
        List<Integer> inp = List.of(1, 2);
        PickFromBothSides bothSides = new PickFromBothSides();
        int ans = bothSides.solve(new ArrayList<>(inp), 1);
        System.out.println(ans);
    }
}
