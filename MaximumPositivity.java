public class MaximumPositivity {
    public int[] solve(int[] A) {
        int n = A.length, aStart = 0, start = 0, end = 0, length = 0;
        for (int i = 0; i < n; i++) {
            start = i;
            while (i < n && A[i] > 0)
                i++;

            if (length < ( i - start)) {
                length = (i -start);
                aStart = start;
                end = (i - 1);
            }

        }

        int[] result = new int[length];

        int index = 0;
        for (int i = aStart; i <= length; i++) {
            result[index++] = A[i];
        }

        return result;

    }

    public static void main(String[] args) {
        MaximumPositivity maximumPositivity = new MaximumPositivity();
        int arr[] = { 8986143, -5026827, 5591744, 4058312, 2210051, 5680315, -5251946, -607433, 1633303, 2186575 };
        int[] ans = maximumPositivity.solve(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
