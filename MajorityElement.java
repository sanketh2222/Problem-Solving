public class MajorityElement {

    public int repeatedNumber(int[] A) {
        if (A.length < 2)
            return A[0];

        int firstMajorityElement = A[0], firstMajorityFreq = 1;
        int secondMajorityElement = A[1], secondMajorityFreq = 1;

        for (int i = 2; i < A.length; i++) {
            if (A[i] == firstMajorityElement)
                firstMajorityFreq++;
            else if (A[i] == secondMajorityElement)
                secondMajorityFreq++;
            else {

                if (firstMajorityFreq == 0) {
                    firstMajorityElement = A[i];
                    firstMajorityFreq++;

                } else if (secondMajorityFreq == 0) {
                    secondMajorityElement = A[i];
                    secondMajorityFreq--;

                } else {
                    firstMajorityFreq--;
                    secondMajorityFreq--;

                }

            }

        }

        firstMajorityFreq = 0;
        secondMajorityFreq = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == firstMajorityElement) {
                firstMajorityFreq++;

            } else if (A[i] == secondMajorityElement) {
                secondMajorityFreq++;
            }

        }

        if (firstMajorityFreq > A.length / 3) {
            return firstMajorityElement;

        } else if (secondMajorityFreq > A.length / 3) {
            return secondMajorityElement;
        }

        return -1;

    }

    public int repeatedNumber2(int[] A) {

        if (A.length < 2)
            return A[0];

        int firstMajorityElement = A[0], firstMajorityFreq = 1;
        int secondMajorityElement = A[A.length - 1], secondMajorityFreq = 1;

        for (int i = 2; i < A.length - 1; i++) {

            if (A[i] == firstMajorityElement)
                firstMajorityFreq++;
            else if (A[i] == secondMajorityElement)
                secondMajorityFreq++;
            else {
                if (firstMajorityFreq == 0) {
                    firstMajorityElement = A[i];
                    firstMajorityFreq++;

                } else if (secondMajorityFreq == 0) {
                    secondMajorityElement = A[i];
                    secondMajorityFreq++;

                } else {
                    firstMajorityFreq--;
                    secondMajorityFreq--;

                }

            }

        }

        firstMajorityFreq = 0;
        secondMajorityFreq = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == firstMajorityElement) {
                firstMajorityFreq++;

            } else if (A[i] == secondMajorityElement) {
                secondMajorityFreq++;

            }

        }

        if (firstMajorityFreq > A.length / 3) {
            return firstMajorityElement;
        } else if (secondMajorityFreq > A.length / 3) {
            return secondMajorityElement;
        }

        return -1;

    }

    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        int[] arr = { 1, 1, 1, 2, 3, 5, 7 };
        // int ans = element.repeatedNumber(arr);
        int ans1 = element.repeatedNumber2(arr);
        // System.out.println(ans);
        System.out.println(ans1);
        System.out.println(2^8);
    }
}
