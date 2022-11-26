// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// public class Solution {

//     public void printArr(Integer[] prefixSumArray) {
//         for (int i = 0; i < prefixSumArray.length; i++) {
//             System.out.print(prefixSumArray[i]);
//         }
//     }

//     public int solve(ArrayList<Integer> A) {
//         Integer[] prefixSumArray = new Integer[A.size()];

//         prefixSumArray[0] = A.get(0);
//         for (int i = 1; i < A.size(); i++) {
//             prefixSumArray[i] = prefixSumArray[i - 1] + A.get(i);
//         }
//         // printArr(prefixSumArray);
//         for (int i = 0; i < A.size(); i++) {
//             int sumLeft = 0, sumRight = 0;
//             sumLeft = getSumLeft(i, prefixSumArray, A);
//             sumRight = getSumRight(i, A.size(), prefixSumArray);

//             if (sumLeft == sumRight) {
//                 // System.out.println(sumLeft);
//                 return i;
//             }

//         }

//         return -1;

//     }

//     public int getSumLeft(int index, Integer[] prefixSumArray, ArrayList<Integer> A) {
//         if (index == 0)
//             return 0;

//         return prefixSumArray[index - 1];
//     }

//     public int getSumRight(int index, int size, Integer[] prefixSumArray) {
//         if (index == size - 1)
//             return 0;

//         return prefixSumArray[size - 1] - prefixSumArray[index];
//     }

//     public static void main(String[] args) {
//         Solution solution = new Solution();

//         List<Integer> A = Arrays.asList(-7, 1, 5, 2, -4, 3, 0);
//         int res = solution.solve(new ArrayList<>(A));
//         System.out.println(res);
//     }
// }


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Solution {
    
    public class MarksSorter implements Comparator<String> {
        
        @Override
        public int compare(String o1,String o2) {
            int marks1 = Integer.parseInt(o1.substring(o1.length() - 2));
            int marks2 = Integer.parseInt(o2.substring(o2.length() - 2));
            if (marks1 > marks2){
                return -1;
            } else if (marks1 == marks2){
                return 1;
            }else {
                return 0;
            }
        }
    }
    
    public ArrayList<String> solve(ArrayList<String> A) {
        List<String> res = A.stream().sorted(new MarksSorter()).collect(Collectors.toList());
        return new ArrayList<>(res);
    }
}

