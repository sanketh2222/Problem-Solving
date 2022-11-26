import java.util.ArrayList;
import java.util.List;

public class GoodSubArrays {

    public int findGoodSubArrays(ArrayList<Integer> A, int B) {
        int count = 0, subArrayLength = 0;
        for (int i = 0; i < A.size(); i++) {
            int sum = 0;
            for (int j = i; j < A.size(); j++) {
                sum += A.get(j);
                subArrayLength = (j - i + 1);
                if (subArrayLength % 2 == 0 && sum < B)
                    count += 1;
                else if (subArrayLength % 2 == 1 && sum > B)
                    count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> inp = List.of(1, 2, 3, 4, 5);
        GoodSubArrays arrays = new GoodSubArrays();
        int ans = arrays.findGoodSubArrays(new ArrayList<>(inp), 4);
        System.out.println(ans); //6
    }
}