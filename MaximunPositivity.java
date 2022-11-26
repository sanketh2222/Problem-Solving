public class MaximunPositivity {

    public int[] solve(int[] A) {
        int n = A.length;
        int left = 0, right = 0, length = 0,start = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] < 0 ){
                int  lstart = 0, rstart = 0;
            left = 0;
            right = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > 0) {
                    left++;
                    lstart = j;
                } else {
                    break;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (A[j] > 0) {
                    right++;
                    rstart = i + 1;
                } else {
                    break;
                }
            }

            if (right > left && rstart > start) {
                start = rstart;
                length = right;
            } else if (right < left && lstart > start) {
                start = lstart;
                length = left;
            }
            }
        }

        int[] ans = new int[length];
        int index = 0;
        for (int i = start; i < length; i++) {
            ans[index++] = A[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximunPositivity m = new MaximunPositivity();
        int[] in =  {8986143, -5026827, 5591744, 4058312, 2210051, 5680315, -5251946, -607433, 1633303, 2186575};
        int[] a = m.solve(in);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

    }
}
