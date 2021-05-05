import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;

public class ThreeSum {
    
    public List<List<Integer>> threeSum(Integer[] nums) {
       Arrays.sort(nums);

        List<List<Integer>> pair = new ArrayList<>();
        HashSet<String> set = new HashSet<String>();
        List<Integer> triplets = new ArrayList<>();

        /*
         * Iterate over the array from the start and consider it as the first element
         */
        for (int i = 0; i < nums.length - 2; i++) {

            // index of the first element in the
            // remaining elements
            int j = i + 1;

            // index of the last element
            int k = nums.length - 1;

            while (j < k) {

                if (nums[i] + nums[j] + nums[k] == 0) {

                    String str = nums[i] + ":" + nums[j] + ":" + nums[k];

                    if (!set.contains(str)) {

                        // To check for the unique triplet
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[k]);
                        pair.add(triplets);
                        triplets = new ArrayList<>();
                        set.add(str);
                    }

                    // increment the second value index
                    j++;

                    // decrement the third value index
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0)
                    j++;

                else
                    k--;
            }
        }
        return pair;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 6
        // -1 0 1 2 -1 -4

        // -1 0 1
        // -1 -1 2
        Integer n = scanner.nextInt();
        Integer nums[] = new Integer[n];
        for(Integer i = 0 ; i < n ;i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        List<List<Integer>> result = new ThreeSum().threeSum(nums);
        for (Integer i = 0; i < result.size(); ++i) {
            System.out.printf("%d %d %d\n", result.get(i).get(0), result.get(i).get(1), result.get(i).get(2));
        }
    }
}
