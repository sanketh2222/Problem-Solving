public class DivisibilityBy8 {

    public int solve(String A) {
        char[] numArray = A.toCharArray();
        int ans = 0, base = 1, num = 0;

        if (numArray.length < 3)
            return (Integer.valueOf(A)) % 8 == 0 ? 1 : 0;

        for (int i = numArray.length - 1; i >= numArray.length - 3; i--) {
            ans += base * Integer.parseInt(String.valueOf(numArray[i]));
            base = base * 10;
        }
        return ans % 8 == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        DivisibilityBy8 by8 = new DivisibilityBy8();
        String A = "16";
        int ans = by8.solve(A);
        System.out.println(ans);

    }
}
