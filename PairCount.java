public class PairCount {

    // use subarray method
    public int solve(String A) {
        long aCount = 0, pairCount = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'A')
                aCount += 1;
            else if (A.charAt(i) == 'G')
                pairCount += aCount;
        }
        Math.abs(1-2);
        return (int)( pairCount % 10000000007L) ;
    }

    public static void main(String[] args) {
        String s = "ABCGAG";
        int aCount = 0, pairCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                aCount += 1;
            else if (s.charAt(i) == 'g')
                pairCount += aCount;
        }

        System.out.println(pairCount);

        long M = 10000000007L;
    }
}
