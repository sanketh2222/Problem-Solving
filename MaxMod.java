import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxMod {

    private static List<Integer> inpList;

    public static int solve(ArrayList<Integer> A) {
        int maxModValue = 0;
        
        Integer[] array = A.toArray(new Integer[A.size()]);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    if ((array[i] % array[j]) > maxModValue)
                        maxModValue = array[i] % array[j];
                } catch (ArithmeticException e) {

                }
            }
        }

        return maxModValue;
    }

    public static void main(String[] args) {
        inpList = Arrays.asList(2, 6, 4);
        int maxModValue = solve(new ArrayList<>(inpList));
        System.out.println(maxModValue);
    }
}
