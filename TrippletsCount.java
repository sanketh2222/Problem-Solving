import java.util.ArrayList;
import java.util.List;

public class TrippletsCount {

    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int ans = 0;
        for (int i = 1; i < N - 1; i++) {
            // find count of elemnts which are less than a[i]
            int left = 0, right = 0;
            for (int j = i - 1; j >= 0; j--) {
                // System.out.println(i + j+"");
                // System.out.println("i " + i + "j" + j);
                if (A.get(j) < A.get(i))
                    left++;
            }

            // find count of elemnts which are greater than a[i]
            for (int j = i + 1; j < N; j++) {
                if (A.get(j) > A.get(i))
                    right++;
            }

            ans += (left * right);

        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> lst = List.of(26, 23, 23, 16, 27, 18, 7);
        TrippletsCount count = new TrippletsCount();
        int ans = count.solve(new ArrayList<>(lst));
        System.out.println(ans);
    }
}
