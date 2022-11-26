import java.util.*;

public class ElementsRemoval {

    public int solve(int[] A) {
        // Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        A = Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += (i + 1) * A[i];

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 0, 10 };
        ElementsRemoval elementsRemoval = new ElementsRemoval();
        int ans = elementsRemoval.solve(arr);
        System.out.println(ans);

    }
}
