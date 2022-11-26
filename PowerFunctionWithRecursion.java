public class PowerFunctionWithRecursion {

    public static int pow(int A, int B, int C) {
        if (B == 0 && C!=0)
            return (1 % C);
        if (B == 0)
            return 1;
        

        int halfPower = pow(A,B/2,C);
        int halfAns = (int)((long)(halfPower % C) * halfPower % C) % C;
        if (B % 2 == 0){
            return halfAns;
        }
        if (A < 0)
             return  (A % C) * ( halfAns % C) + C;
        return  (int)((long)(A % C) *   halfAns % C);
    }
    
    public static void main(String[] args) {
       int ans = PowerFunctionWithRecursion.pow(71045970, 41535484, 64735492);
       System.out.println(ans);
       System.out.println(-1 % 20);
        
    }
}
