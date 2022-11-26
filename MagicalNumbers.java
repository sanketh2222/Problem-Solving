public class MagicalNumbers {

    public int solve(int A) {
        int base = 5, power = 1, result = 0;
        int binary = DecimalToAnyBase(A, 2);
        while (binary != 0) {
            int bit = binary % 10;
            result += bit * Math.pow(base, power);
            binary /= 10;
            power++;

        }

        return result;
    }

    public int solve1(int A) {
        int base = 5, power = 1, result = 0;
        while(A != 0){
            if ((A & 1) == 1){
                result += Math.pow(base, power);
     
            }
            A = A >> 1;
            power++;
        }

        return result;
    }

    public int DecimalToAnyBase(int A, int B) {
        int result = 0, power = 0, base = 10;
        while (A != 0) {
            int rem = A % B;
            A = A / B;
            result += rem * Math.pow(base, power);
            power++;
        }
        return result;
    }

    public static void main(String[] args) {
        MagicalNumbers magicalNumbers = new MagicalNumbers();
        // int ans = magicalNumbers.solve1(10);
        // System.out.println(ans);
        // System.out.println(Math.pow(2,30));
        // int ans = magicalNumbers.DecimalToAnyBase(0, 0)
        System.out.println(93 & 92);
    }
}
