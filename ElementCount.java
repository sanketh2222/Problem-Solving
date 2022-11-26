import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ElementCount {
    private Integer integer;
    private List<Integer> sorted;

    public int maxElement(ArrayList<Integer> A) {
        Integer maxValue = A.stream().max(Integer::compare).get();
        return maxValue.intValue();
    }

    public ArrayList<Integer> solve2(ArrayList<Integer> A) {
        Integer prefixSumArray[] = new Integer[A.size()];
        int prefixSum = 0;

        for(int i = 0; i < A.size(); i++){
            prefixSum += A.get(i);
            prefixSumArray[i] = prefixSum;
        }
        
        
        List<Integer> result = Arrays.stream(prefixSumArray).collect(Collectors.toList());
        return new ArrayList<>(result);
    }

    public ArrayList<Integer> solve22(ArrayList<Integer> A) {
        Integer prefixSumArray[] = new Integer[A.size()];
        int prefixSum = 0;

        for(int i = 0; i < A.size(); i++){
            prefixSum += A.get(i);
            prefixSumArray[i] = prefixSum;
        }

        List<Integer> result = Arrays.stream(prefixSumArray).collect(Collectors.toList());
        List<Integer> resul  = Arrays.stream(prefixSumArray).collect(Collectors.toList());
        return new ArrayList<>(result);
    }

    public int solve(ArrayList<Integer> A, int B) {
        for (int i = 0; i < A.size(); i++) {
            int target = B - A.get(i);
            if (i < A.size() - 1 && (A.get(i + 1) == target))
                return 1;
        }
        return 0;
    }

    public int checkPair(ArrayList<Integer> A, int B) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) + A.get(j) == B)
                    return 1;

            }
        }
        return 0;
    }

    public ArrayList<Integer> reverseList(final List<Integer> A) {
        // A.sort(Comparator.reverseOrder());
        // A.forEach(System.out::println);
        sorted = A.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        // sorted.forEach(System.out::println);
        return new ArrayList<Integer>(sorted);
    }

    public Object getKycType(){
        return new MaxMod();
    }

    public ArrayList<Integer> reverseArrayList(final List<Integer> A) {
        Integer[] reversedArray = A.toArray(new Integer[A.size()]);

        // Start the actual logic for reverse
        int start = 0, end = A.size() - 1;
        while (start < end) {
            swap(reversedArray, start, end);
            start += 1;
            end -= 1;
        }

        // end the reverse logic
        List<Integer> reversedList = Arrays.stream(reversedArray).collect(Collectors.toList());

        return new ArrayList<Integer>(reversedList);
    }

    public ArrayList<Integer> swapArrayListInRange(final List<Integer> A, int start, int end) {
        Integer[] listAsArray = A.toArray(new Integer[A.size()]);
        while (start < end) {
            swap(listAsArray, start, end);
            start += 1;
            end -= 1;

        }
        List<Integer> result = Arrays.stream(listAsArray).collect(Collectors.toList());
        return new ArrayList<Integer>(result);
    }

    public void swap(Integer arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public void reverseArray(Integer arr[]){
        int start = 0, end = arr.length - 1;
        while (start < end ){
            swap(arr, start , end);
            start += 1;
            end -= 1;
        } 
    }

    public ArrayList<Integer> rotateArrayList2(ArrayList<Integer> arr, int k){
        k =  k % arr.size();// 10 % 6
        
        if (k == 0) return arr;
        // reverseArray(inputArray);

        arr = reverseArrayList(arr);
        // System.out.println("converted array");
        //  //Printed the rotated array
        // for (Integer integer : arr) {
        //     System.out.println(integer);
        // }

        //swap the first k elements of the array ([0 - k -1])
        // swap(inputArray, 0, k -1);
        arr = swapArrayListInRange(arr, 0, k -1);

        //swap (n-k) elements of the array([k - N -1])
        // swap(inputArray, k, arr.size() - 1);
        arr = swapArrayListInRange(arr, k, arr.size() - 1);
       

        // List<Integer> result = Arrays.stream(inputArray).collect(Collectors.toList());

        
        //given array will not change
        // System.out.println("given array");
        // arr.forEach(System.out::println);
        return arr;
    }

    public ArrayList<Integer> rotateArrayList(ArrayList<Integer> arr, int k){
        k =  k % arr.size();// 10 % 6

        if (k == 0){
            return arr;
        }

        Integer[] inputArray = arr.toArray(new Integer[arr.size()]);

        reverseArray(inputArray);
        // System.out.println("after reverse array");
        // for (Integer integer : inputArray) {
        //     System.out.println(integer);
        // }
        //swap the first k elements of the array ([0 - k -1])
        int start = 0 , end = k -1;
        while (start < end) {
            swap(inputArray, 0, k -1);
            start += 1;
            end -=1;
        }
        

        // System.out.println("after swap 1");
        // for (Integer integer : inputArray) {
        //     System.out.println(integer);
        // }

        //swap (n-k) elements of the array([k - N -1])
        start = k; end = arr.size() - 1;
        while (start < end) {
            swap(inputArray, k, arr.size() - 1);
            start += 1;
            end -= 1;
        }
       

        // System.out.println("after swap 2");
        // for (Integer integer : inputArray) {
        //     System.out.println(integer);
        // }
       
        List<Integer> result = Arrays.stream(inputArray).collect(Collectors.toList());

        return new ArrayList<Integer>(result);
    }

    public static void main(String[] args) {
        ElementCount count = new ElementCount();
        // List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
        // int maxValue = count.maxElement(new ArrayList<>(list));
        // System.out.println(maxValue);
        List<Integer> list = Arrays.asList(510827, 351151, 96897, 925335, 299818, 192489, 456948, 44720, 510589,
                598577);
        // int ans = count.solve(new ArrayList<>(list), 808099);
        // int ans = count.checkPair(new ArrayList<>(list), 808099);
        // System.out.println(ans);
        List<Integer> list2 = Arrays.asList(-9, -18, 0, 25, 4);
        // ArrayList<Integer> result = count.reverseArrayList(list2);
        // result.forEach(System.out::println);
        // List<Integer> list3 = Arrays.asList(2,5,6);
        // result = count.swapArrayListInRange(list3,0,2);
        // result.forEach(System.out::println);

        //[ 7, 4, 2, 10, 5 ]
        //B = 10
        List<Integer> list3 = Arrays.asList(1, 1, 4, 9, 4, 7, 1);
        List<Integer> result = count.rotateArrayList2(new ArrayList<>(list3), 9);
        result.forEach(System.out::println);
        count.getKycType().getClass();

    }
}