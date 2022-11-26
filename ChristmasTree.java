public class ChristmasTree {
    public int solve(int[] A, int[] B) {
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < B.length; i++) {
            for (int j = i + 1; j < B.length; j++) {
                for (int k = j + 1; k < B.length; k++) {
                    if ((B[i] + B[j] + B[k]) < minCost)
                        minCost = B[i] + B[j] + B[k];
                }
            }
        }
        return minCost;
    }

    public int solve1(int[] A, int[] B) {
        int minCost = Integer.MAX_VALUE;
   
        for (int i = 1; i < B.length; i++) {
            long minleft = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE;
            // find minLeft
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i] && B[j] < minleft)
                    minleft = B[j];
            }

            for (int j = i + 1; j < B.length; j++) {
                if (A[j] > A[i] && B[j] < minRight)
                    minRight = B[j];
            }
            long minCostSum = (minleft + B[i] + minRight);
            if (minCostSum < minCost)
                minCost = (int)minCostSum;

        }
        
        return minCost == Integer.MAX_VALUE ? -1: minCost;
    }

    public int testLoop(int[] arr, int[] brr) {
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1, k = i + 1;
            while (j >= 0 || k < arr.length) {
                // System.out.print(arr[i]);
                // System.out.print(arr[j--]);
                // System.out.print(arr[k++]);
                if ((arr[i] < arr[j]) && (arr[j] < arr[k]) && brr[i] + brr[j] + brr[k] < minCost) {
                    minCost = brr[i] + brr[j] + brr[k];
                }

                if (j >= 0)
                    j--;
                k++;
            }
        }

        return minCost;

    }

    public static void main(String[] args) {
        ChristmasTree christmasTree = new ChristmasTree();
        int[] a = { 100, 101, 100 };
        int[] b = {  2, 4, 5 };
        int ans = christmasTree.solve1(a, b);
        // System.out.println(ans);
        // int ans = christmasTree.testLoop(a, b);
        System.out.println(ans);
    }
}
