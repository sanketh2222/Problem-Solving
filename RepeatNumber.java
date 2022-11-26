public class RepeatNumber {

    public int repeatedNumber(int[] A) {
        int maxElement = A[0], freq = 0;
        for (int i = 0; i < A.length; i++) {
            if (freq == 0) {
                maxElement = A[i];
                freq++;
            } else {
                if (A[i] == maxElement)
                    freq++;
                else
                    freq--;
            }
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == maxElement)
                count++;
        }

        if (count > (A.length / 3))
            return maxElement;

        return -1;

    }

    public static void main(String[] args) {
        RepeatNumber number = new RepeatNumber();
        int[] inp = { 1, 1, 1, 2, 3, 5, 7};
        number.repeatedNumber(inp);

    }
}
