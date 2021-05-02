import java.util.stream.Collector;
// import java.util.stream.Collectors;
import java.util.*;

public class ThreeSum {

    public void createTempset() {
        
    }

    public List<List<Integer>> threeSum(Integer[] nums) {
        List<List<Integer>> result1 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Set<String> tempset = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0//3!
                            && !tempset.contains(nums[i] + " " + nums[j] + " " + nums[k] )//0 0 0//
                            && !tempset.contains(nums[i] + " " + nums[j] + " " + nums[k])
                            && !tempset.contains(nums[i] + " " + nums[k] + " " + nums[k])
                            && !tempset.contains(nums[i] + " " + nums[k] + " " + nums[k])
                            && !tempset.contains(nums[j] + " " + nums[i] + " " + nums[k])
                            && !tempset.contains(nums[j]+ " " + nums[i] + " " + nums[k])//
                            && !tempset.contains(nums[j] + " " + nums[k] + " " + nums[k])//1 1 1
                            && !tempset.contains(nums[j] + " " + nums[k] + " " + nums[k])) {
                        // System.out.printf("rsult is"+nums[i]+""+nums[j]+""+nums[k]);

                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        // if ()

                        tempset.add(nums[i] + " " + nums[j] + " " + nums[k]);


                        // temp1 = temp.stream().collect(Collectors.toList());//O(1)   {}()
                        // temp1 = new ArrayList<>();
                        // temp1.addAll(temp);
                       
                        // result1.
                        // temp1=temp;
                        // // System.out.printf("temp is"+temp);
                        result1.add(temp);// temp
                        // // System.out.printf("add res is"+result);
                        // temp.clear();
                        temp = new ArrayList<>();
                    }
                }

            }
            // System.out.printf("add res is"+result1);
        }
        // for (int i=0;i<temp.size();i+=3){

        // }
        // System.out.printf("rsult is"+result1);
        return result1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 6
        // -1 0 1 2 -1 -4

        // -1 0 1
        // -1 -1 2

        // -1 0 1 
        // -1 2 -1
        // 0 1 -1
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
