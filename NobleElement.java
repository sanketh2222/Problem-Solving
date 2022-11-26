import java.util.Arrays;
import java.util.Collections;

public class NobleElement {

    public int solve(int[] A) {
        int currentElement = A[0], count = 0, nobleCount = 0;
        A = Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < A.length; i++){
            if (A[i] != currentElement){
                currentElement = A[i];
                count=i;
                if (count == A[i])
                    nobleCount+=1;
            }else if (count == A[i]){
                nobleCount+=1;
            }
        }

        return nobleCount == 0 ? -1:1;
    }
    
    public static void main(String[] args) {
        int[] arr = { 4,4,4,4};
        NobleElement element = new NobleElement();
        int ans = element.solve(arr);
        System.out.println(ans);
    }
}
