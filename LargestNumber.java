import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

    public class SortByFirstDigit implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            int firstDigitFirstNum = getFirstDigit(o1.intValue());
            int firstDigitSecNum = getFirstDigit(o2.intValue());
            if (firstDigitFirstNum > firstDigitSecNum){}
            return 0;
        }

    }

    private int getFirstDigit(int n){
        int lastDigit = 0;
        while (n !=0){
            lastDigit = n % 10;
            n = n/10;
        }
        return lastDigit;
    }

    public String largestNumber(final int[] A) {
       return null;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        // System.out.println(arr.toString());
        for (int i = 0; i < arr.length; i++) {
            // System.out.println(Arrays.toString(arr[i]));
        }
        // char ch = 'A';
        // ch ^= 32;
        String str ="abcd";
        // str[0] = "d";
        
        for(char ch:str.toCharArray()){
            ch ^= 32;
        }
        System.out.println(str);
        Arrays.sort(str.toCharArray());
 
        
    }
}
