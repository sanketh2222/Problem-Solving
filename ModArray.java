import java.util.Arrays;

public class ModArray {

    public int solve(int[] A, int B) {
        int ans = 0, r = 1;
        for (int i = A.length - 1 ; i >= 0; i--){
            ans = ans + ( (A[i] % B) * r) % B;
            r = (r * 10) % B;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        ModArray array = new ModArray();
        int[] arr = {1, 8, 4, 5, 0, 8, 0};
        int ans  = array.solve(arr,9);
        System.out.println(ans);
        Arrays.sort(arr);
    }
}
