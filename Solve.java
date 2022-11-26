// public class Solve {

//     static int bar(int x, int y){
//         if (y == 0)   return 0;
//         return (x + bar(x, y-1));
//     }

//     static int foo(int x, int y){
//         if (y == 0) return 1;
//         return bar(x, foo(x, y-1));
//     }
//     public static void main (String[] args)
//     {
//          System.out.println(foo(3,5));
//     }

// }

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solve {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        B =  B % A.size();// 10 % 6

        if (B == 0){
            return A;
        }

        A = reverseArrayList(A);

        A = swapArrayListInRange(A, 0 , B - 1);

        A = swapArrayListInRange(A, B, A.size() -1 );

        return A;


    }

    public void swap(Integer arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    static void fun(int[]arr) {

       arr[3] = 98;

       return;

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

    public static void change(Integer x)
    {
        x = 10;
    }

    public static void main(String[] args) {
        int[]arr = {10,20,30,40,50};

        fun(arr);

       System.out.println(arr[3]);

       Integer a = 10;
       change(20);
       System.out.println(a);
    }
}
