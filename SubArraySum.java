import java.util.ArrayList;
import java.util.List;

public class SubArraySum {
    public Long subarraySum(ArrayList<Integer> A) {
        Long sum = 0L;
        int size = A.size();
        for (int i = 0; i < A.size(); i++) {
            sum += (size - i) * (i + 1) * Long.valueOf(A.get(i));
        }

        return sum;
    }

    public static void main(String[] args) {
        SubArraySum arraySum = new SubArraySum();
        List<Integer> lst = List.of(1, 2, 3);
        Long sum = arraySum.subarraySum(new ArrayList<>(lst));
        System.out.println(sum);
        ArrayList<ArrayList<Integer>> allSubArraysList = new ArrayList<>();

    }
}
