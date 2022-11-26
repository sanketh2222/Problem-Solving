import java.util.Arrays;

public class MultipleLeftRotations {

    public int[][] solve(int[] A, int[] B) {
        int[][] result = new int[B.length][A.length];
        int[] inp = A;
        int index = 0;
        for (int ele : B) {
            inp = Arrays.copyOf(A, A.length);;
            reverseArray(inp, 0, A.length - 1);
            ele = ele % A.length;
            reverseArray(inp, 0, A.length - 1 - ele);
            reverseArray(inp, A.length - ele, A.length - 1);
            result[index++] = inp;
        }
        return result;
    }

    public int[] reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        return arr;

    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] A = { 6, 31, 33, 13, 82, 66, 9, 12, 69, 21, 17, 2, 50, 69, 90, 71, 31, 1, 13, 70, 94, 46, 89, 13, 55, 54, 67, 97, 28, 27, 62, 34, 41, 18, 15, 35, 13, 84, 93, 27, 89, 23, 6, 56, 94, 40, 54, 95, 47 };
        int[] B = { 88, 85, 98, 36, 66, 40, 30, 26, 51, 77, 62, 60, 92, 64, 53, 86, 24, 53, 85, 49, 57, 29, 32, 60, 75, 82, 17, 23, 67, 51, 23, 11, 70, 59 };
        MultipleLeftRotations leftRotations = new MultipleLeftRotations();
        int[][] ans = leftRotations.solve(A, B);

    }
}
