import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondLargestElement {
    public int solve(ArrayList<Integer> A) {

        // if (A.size() == 1)
        //     return -1;

        int fisrt_max = getMaxElement(A);
        int second_max = Integer.MIN_VALUE;

        for (Integer element : A) {
            if (element > second_max && element < fisrt_max)
                second_max = element;
        }

        return second_max == Integer.MIN_VALUE ? -1 : second_max;

    }

    public Integer getMaxElement(List<Integer> arr) {
        int maxElement = Integer.MIN_VALUE;
        for (Integer element : arr) {
            if (element > maxElement)
                maxElement = element;
        }
        return maxElement;
    }

    public static void main(String[] args) {
        SecondLargestElement element = new SecondLargestElement();
        List<Integer> arr = Arrays.asList( 13);
        int result = element.solve(new ArrayList<>(arr));
        System.out.println(result);

    }
}
