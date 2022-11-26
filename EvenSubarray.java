import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EvenSubarray {

    public static String solve(ArrayList<Integer> A) {
        Integer[] arr = A.toArray(new Integer[A.size()]);
        boolean isPossible = true;
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                boolean isEvenSubarray = (j - i + 1) % 2 == 0;
                if (isEvenSubarray && (arr[i] % 2 != 0 || arr[j] % 2 != 0)) {
                    isPossible = false;
                    break;
                }
            }
        }
        if (isPossible)
            return "YES";
        return "NO";
    }

    // brute force TC -> O(N*N) SC-> O(1)
    public static String isEvenSubarray(Integer[] arr) {
        boolean isPossible = true;
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                boolean isEvenSubarray = (j - i + 1) % 2 == 0;
                if (isEvenSubarray && (arr[i] % 2 != 0 || arr[j] % 2 != 0)) {
                    isPossible = false;
                    break;
                }
            }
        }
        if (isPossible)
            return "YES";
        return "NO";
    }

    public static void test(int[] arr){
        arr[0]= 10;
    }

    public static ArrayList<Integer> buildRightMax(ArrayList<Integer> A) {
        // List<Integer> result = new ArrayList<>(Collections.nCopies(A.size(), 0));
        Integer[] rMaxArray = A.toArray(new Integer[A.size()]);
        rMaxArray[A.size() - 1] = A.get(A.size() - 1);

        for(int i = A.size() - 2; i >= 0 ; i--){
            rMaxArray[i] = Math.max(rMaxArray[i + 1], A.get(i));
        }
        List<Integer> result = Arrays.stream(rMaxArray).collect(Collectors.toList());
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 8, 6 };

        List<Integer> arrList = Arrays.asList(978, 847, 95, 729, 778, 586, 188, 782, 813, 870, 871, 940, 312, 693, 580,
                101, 760, 837, 564, 633, 680, 155, 241, 374, 682, 290, 850, 601, 433, 922, 773, 959, 530, 290, 990, 50,
                516, 409, 868, 131, 664, 851, 721, 880, 20, 450, 745, 387, 787, 823, 392, 242, 674, 347, 65, 135, 819,
                324, 651, 678, 139, 940);
        // Integer[] al = arrList.toArray(new Integer[10]);//A.toArray(new
        // Integer[A.size()]);
        // String result = solve(new ArrayList<>(arrList));
        // System.out.println(arrList.size());
        // String isPossible = isEvenSubarray(al);
        // System.out.println(isPossible);
        List<Integer> finalList = new ArrayList<>();

        List<Integer> eList = Arrays.asList(17, 17, 5, 5, 5, 2);
        eList.forEach(ele -> {
            if (!finalList.contains(ele)) {
                finalList.add(ele);
            }
        });
        List<Integer> lst = Arrays.asList(16, 17, 4, 3, 5, 2);
        // finalList.forEach(System.out::println);
        List<Integer> rMax = buildRightMax(new ArrayList<>(lst));

        rMax.forEach(System.out::println);
        int arr1[] = {1,2,3,4};
        test(arr1);
        System.out.println(arr1[2]);
    }
}
