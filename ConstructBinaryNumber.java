public class ConstructBinaryNumber {

    public int solve(int A, int B) {
        int[] binary = new int[A + B];
        int power = 0, base = 2;
        for (int i = 0; i < A; i++) {
            binary[i] = 1;
        }

        for (int i = A ; i < B; i++) {
            binary[i] = 0;
        }

        double ans = 0;
        for (int i = binary.length - 1; i >= 0; i--) {
            ans += binary[i] * Math.pow(base, power);
            power++;
        }
        
        
        return (int)ans;
    }

    public int solve1(int A, int B) {
        int[] binary = new int[A+B];
        int power = 0, base = 2;
        
        for (int i = 0; i < A ; i++){
            binary[i] = 1;
        }
        
        for (int i = 0; i < B; i++){
            binary[i] = 0;
        }
        
        double ans = 0;
        for (int i = binary.length - 1; i >=0; i--){
            ans += binary[i]* Math.pow(base,power);
            power++;
        }
        
        return (int)ans;
    }

    public static void main(String[] args) {
        ConstructBinaryNumber binaryNumber = new ConstructBinaryNumber();
        int A = 5;
        int B = 4;
        int ans =  binaryNumber.solve(A, B);
        int ans1 =  binaryNumber.solve1(A, B);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
