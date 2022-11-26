import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonElements {

    private static List<Integer> B;
    private static List<Integer> A;
    private static ArrayList<Integer> result;

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
                if(B.contains(A.get(i))){
                    result.add(A.get(i));
                }
                
            
        }

        return result;
    }

    public static void main(String[] args) {
        //[1,2,2,1]
        //[2,3,1,2]
        A = Arrays.asList(1,2,2,1);
        B = Arrays.asList(2,3,1,2);
        // result = solve(new ArrayList<>(A), new ArrayList<>(B));
        // System.out.println(result);
        // result.forEach(System.out::println);
        System.out.println(A.contains(2));
    }
}
