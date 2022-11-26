public class UnsetBit {

    public int solve(int A, int B) {
        int res = (A >> B);
        if ((res & 1 ) == 1){
             return A ^ (1 << B);
        }else {
            return A;
        }
           
        // return res;
    }

    public int DecimalToAnyBase(int A, int B) {
        int result = 0, power = 0, base = 10;
        while (A != 0) {
            int rem = A % B;
            A = A / B;
            result += rem * Math.pow(base,power);
            power++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        UnsetBit bit = new UnsetBit();
        int ans = bit.solve(5, 2);
        // System.out.println(ans);
        int a = 10;
        int ans1 = bit.DecimalToAnyBase(a, 2);
        System.out.println(ans1);

        
    }
}
