import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HillArea {
    private static List<Integer> A;
    private static String solve;

    public static String solve(ArrayList<Integer> A) {
        Long sum = 0L;
        for(Integer num:A)
            sum+=num;
        

        return sum.toString();
    }

    public static void main(String[] args) {
        A = Arrays.asList(1,2,3,4);
        solve = solve(new ArrayList<>(A));
        System.out.println(solve);
    }
}
