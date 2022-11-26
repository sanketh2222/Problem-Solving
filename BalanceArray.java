// Java program to implement
// the above approach
class BalanceArray {

    // Function to count array indices
    // whose removal makes sum of odd and
    // even indexed elements equal
    static int cntIndexesToMakeBalance(int arr[], int n) {

        // If size of the array is 1
        if (n == 1) {
            return 1;
        }

        // If size of the array is 2
        if (n == 2)
            return 0;

        // Stores sum of even-indexed
        // elements of the given array
        int sumEven = 0;

        // Stores sum of odd-indexed
        // elements of the given array
        int sumOdd = 0;

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // If i is an even number
            if (i % 2 == 0) {

                // Update sumEven
                sumEven += arr[i];
            }

            // If i is an odd number
            else {

                // Update sumOdd
                sumOdd += arr[i];
            }
        }

        // Stores sum of even-indexed
        // array elements till i-th index
        int currOdd = 0;

        // Stores sum of odd-indexed
        // array elements till i-th index
        int currEven = arr[0];

        // Stores count of indices whose
        // removal makes sum of odd and
        // even indexed elements equal
        int res = 0;

        // Stores sum of even-indexed elements
        // after removing the i-th element
        int newEvenSum = 0;

        // Stores sum of odd-indexed elements
        // after removing the i-th element
        int newOddSum = 0;

        // Traverse the array
        for (int i = 1; i < n - 1; i++) {

            // If i is an odd number
            if (i % 2 != 0) {

                // Update currOdd
                currOdd += arr[i];

                // Update newEvenSum
                newEvenSum = currEven + sumOdd
                        - currOdd;

                // Update newOddSum
                newOddSum = currOdd + sumEven
                        - currEven - arr[i];
            }

            // If i is an even number
            else {

                // Update currEven
                currEven += arr[i];

                // Update newOddSum
                newOddSum = currOdd + sumEven
                        - currEven;

                // Update newEvenSum
                newEvenSum = currEven + sumOdd
                        - currOdd - arr[i];
            }

            // If newEvenSum is equal to newOddSum
            if (newEvenSum == newOddSum) {

                // Increase the count
                res++;
            }
        }

        // If sum of even-indexed and odd-indexed
        // elements is equal by removing the first element
        if (sumOdd == sumEven - arr[0]) {

            // Increase the count
            res++;
        }

        // If length of the array
        // is an odd number
        if (n % 2 == 1) {

            // If sum of even-indexed and odd-indexed
            // elements is equal by removing the last element
            if (sumOdd == sumEven - arr[n - 1]) {

                // Increase the count
                res++;
            }
        }

        // If length of the array
        // is an even number
        else {

            // If sum of even-indexed and odd-indexed
            // elements is equal by removing the last element
            if (sumEven == sumOdd - arr[n - 1]) {

                // Increase the count
                res++;
            }
        }

        return res;
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = { 5, 5, 2, 5, 8 };
        int n = arr.length;
        // System.out.println(cntIndexesToMakeBalance(arr, n));
        String dataType = "GST";
        System.out.println(dataType == "GST");
        System.out.println(dataType.equals("GST"));
    }
}

// This code is contributed by AnkitRai01
