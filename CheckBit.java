public class CheckBit {

    public int solve(int A, int B) {
        int number = 8;
       
        // 2 bit signed right shift
        int Ans = (A >> B & 1);
        if (Ans == 1)
        System.out.println(Ans);


        return 0;
    }

    public static void main(String[] args) {
        CheckBit bit = new CheckBit();
        bit.solve(4, 1);
        
    }
}
