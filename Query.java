import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Query {

    //TC -> O(M N) 
    //SC -> 0(M)
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int prefixArray[] = new int[A.size()];
        for (ArrayList<Integer> pair : B) {//Max size of B would be M 
            int sum = 0;
            int start = pair.get(0) - 1;
            int end = pair.get(1);
            for (int i = start; i < end; i++) {//Max limit is R <= N so max value of end is N 
                sum += A.get(i);
            }
            result.add(sum);
        }
        return result;
    }

    // private void test(){
    //     int a = 10;
    //     int b = 10;
    //     Long sum = 0L;
    //     sum = Long.valueOf(a+b);

    // }

    private void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int prefixSumArray[] = new int[A.size() + 1];
        prefixSumArray[0] = A.get(0);
        ArrayList<Long> result = new ArrayList<>();
         //build a subarray
        for(int i = 1; i < A.size(); i++){
            prefixSumArray[i] = prefixSumArray[i - 1] + A.get(i);
        }
        // printArray(prefixSumArray);

        for (ArrayList<Integer> pair : B) {
            int start = pair.get(0);
            int end = pair.get(1);
            Long querySum = 0L;
            if (end == A.size())
                end -= 1;
            querySum = Long.valueOf((prefixSumArray[end] - prefixSumArray[start - 1]));
            result.add(querySum);

        }
        
        return result;
    }

    public void test(){
        int retries  = 0;
        while(retries < 4){
            // if (retries == 0){
            //     return;
            // }
            retries+=1;
        }
        System.out.println("failed to execute");
    }

    public static void main(String[] args) {
        Query query = new Query();
        List<Integer> A = Arrays.asList(2, 2, 2);
        ArrayList<ArrayList<Integer>> group = new ArrayList<ArrayList<Integer>>();
        group.add(new ArrayList<>(Arrays.asList(1, 1)));
        group.add(new ArrayList<>(Arrays.asList(2, 3)));
        // ArrayList<Integer> result = query.solve(new ArrayList<>(A), group);
        // System.out.println(result);
        ArrayList<Long> result = query.rangeSum(new ArrayList<>(A), group);
        System.out.println(result);
        query.test();

    }
}
