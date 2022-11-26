import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SubArrayWithGivenSum {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Map<Long, Integer> hashSet = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        hashSet.put(0L, -1);
        long   sum = 0;
        int start = -1, end = -1;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (hashSet.containsKey(sum - B)) {
                start = hashSet.get(sum - B) + 1;
                end = i;
                break;
            } else {
                hashSet.put(sum, i);
            }
        }

        if (start == -1) {
            res.add(-1);
            return res;
        }

        for (int j = start; j <= end; j++) {
            res.add(A.get(j));
        }

        return new ArrayList<>(res.stream().collect(Collectors.toList()));

    }

    public static void main(String[] args) {
        // List<Integer> inp = Arrays.asList(15, 2, 48, 19, 28, 22, 44, 2, 32, 46, 46,
        // 24, 1, 23, 49, 26, 23, 17, 17, 46, 4, 30, 40, 36, 20, 5);
        List<Integer> inp = Arrays.asList(1, 2, 3, 4, 5);
        ArrayList<Integer> res = SubArrayWithGivenSum.solve(new ArrayList<>(inp), 5);
        res.forEach(System.out::println);
    }
}
