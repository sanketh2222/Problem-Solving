import java.util.ArrayList;
import java.util.List;

public class MinSwaps {



    public int findMinSwaps(ArrayList<Integer> A, int B) {
        int k = 0;
        for (int i = 0; i < A.size();i++){
            if (A.get(i) <= B)
                k+=1;
        }

        int badCount = 0;//elements in array which are greater than B are called bad elements
        //all the bad elements in the window need swapping 

        if (k == 0 || k == 1) {return 0;}

        for (int i = 0; i < k; i++){
            if (A.get(i) > B)
                badCount+=1;
        }

        int start = 1, end = B, ans = badCount;

        //apply sliding window
        while (end < A.size()){

            if (A.get(start - 1) > B)  { badCount--;}

            if (A.get(end) > B )  { badCount++;}

            if (badCount < ans)  { ans = badCount;}

            start++;
            end++;
        }

        return badCount;

    }
    
    public static void main(String[] args) {
        List<Integer> inp =  List.of(52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52, 47, 87, 33, 87, 70);
        MinSwaps minSwaps = new MinSwaps();
        int a = minSwaps.findMinSwaps(new ArrayList<>(inp), 19);
        System.out.println(a);
        
    }
}
