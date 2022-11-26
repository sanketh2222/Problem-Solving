import java.util.ArrayList;
import java.util.List;

public class MaxSumSubArray {

    public int maxSubarray(int A, int B, ArrayList<Integer> C) {
        ArrayList<Integer> subArraySum = new ArrayList<>();

        for (int i = 0; i < C.size(); i++) {
            int sum = 0;
            for (int j = i; j < C.size(); j++) {
                sum += C.get(j);
                subArraySum.add(sum);
            }
            
        }
    
        // subArraySum.forEach(System.out::println);
        return getMaxSum(subArraySum, B);
    }

    public int getMaxSum(ArrayList<Integer> arr, int B) {
        int maxSum = -1;
        for (Integer num : arr) {
            if (num > maxSum && num <= B)
                maxSum = num;
        }
        if (maxSum == -1)
            return 0;
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumSubArray array = new MaxSumSubArray();
        List<Integer> lst = List.of(5);
        int sum = array.maxSubarray(1, 6, new ArrayList<>(lst));
        System.out.println(sum);
    }
}
