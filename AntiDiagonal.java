import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AntiDiagonal {

    public ArrayList<ArrayList<Integer>> initializeResultMatrix(ArrayList<ArrayList<Integer>> A) {
        int size = 2 * A.size() - 1;
        ArrayList<ArrayList<Integer>> inpArr = new ArrayList<>();
        int colSize = A.get(0).size();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>(Collections.nCopies(colSize, 0));
            inpArr.add(arr);
        }
        return inpArr;
    }

    public int[][] diagonal(int[][] A) {
        int[][] result = new int[2 * A.length - 1][A.length];
        int resRow = 0;
        for (int i = 0; i < A.length; i++) {
            int row = 0, col = i;
            resRow = i;
            int resCol = row;
            while (row < A.length && col >= 0) {
                System.out.print(A[row][col]);
                result[resRow][resCol++] = A[row][col];
                row++;
                col--;
            }
        }

        for (int j = 1; j < A.length; j++) {
            int row = j, col = A.length - 1;
            resRow+=1;
            int resCol = 0;
            while (col >= 0 && row < A.length) {
                System.out.print(A[row][col]);
                result[resRow][resCol++] = A[row][col];
                row++;
                col--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AntiDiagonal antiDiagonal = new AntiDiagonal();
        // ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        // A.add(new ArrayList<>(List.of(1, 2, 3)));
        // A.add(new ArrayList<>(List.of(4, 5, 6)));
        // A.add(new ArrayList<>(List.of(7, 8, 9)));
        // ArrayList<ArrayList<Integer>> anti = antiDiagonal.initializeResultMatrix(A);
        // anti.forEach(System.out::println);
        // anti.add(1,new ArrayList<>(List.of(1, 2, 3)));
        // anti.forEach(System.out::println);

        // multiDMatrix();
        // only first row size is mandatory for 2d arrays
        // is also correct int[][] matrix = int[3][]
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] result = antiDiagonal.diagonal(matrix);
        // for (int i = 0; i <= 2; i++) {
        // for (int j = 0; j < 2; j++) {
        // System.out.print(result[i][j] + " ");
        // }
        // }
    }

    private static void multiDMatrix() {
        int[][] mat = new int[10][10];
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[0][2] = 3;
        mat[0][3] = 4;
        // System.out.println(mat);
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
    }
}
