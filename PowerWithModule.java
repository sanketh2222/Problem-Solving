public class PowerWithModule {

    public int solve(int A, int B, int C) {
        int ans = 1;
        for (int i = 0; i < B; i++){
            ans = (int)((long)(ans * C)* A * C) ;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
}
