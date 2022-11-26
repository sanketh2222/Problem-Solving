import java.util.ArrayList;
import java.util.List;

public class ColSum {

    public ArrayList<Integer> getColSum(ArrayList<ArrayList<Integer>> arr, int rowSize, int colSize) {
        ArrayList<Integer> colSumArray = new ArrayList<>();
        for (int col = 0; col < colSize; col++) {
            int sum = 0;
            for (int row = 0; row < rowSize; row++) {
                sum += arr.get(row).get(col);

            }
            colSumArray.add(sum);
        }
        return colSumArray;
    }

    public ArrayList<Integer> getRowSum(ArrayList<ArrayList<Integer>> arr, int rowSize, int colSize) {
        ArrayList<Integer> colSumArray = new ArrayList<>();
        for (int row = 0; row < rowSize; row++) {
            int sum = 0;
            for (int col = 0; col < colSize; col++) {
                sum += arr.get(row).get(col);

            }
            colSumArray.add(sum);
        }
        return colSumArray;
    }

    public int getDiagonalSum(ArrayList<ArrayList<Integer>> arr, int rowSize, int colSize) {
        int row = 0, col = 0;
        int sum = 0;
        while (row < rowSize && col < colSize) {
            sum += arr.get(row).get(col);
            row++;
            col++;
        }
        return sum;
    }

    public int findMinorDiagonalSum(ArrayList<ArrayList<Integer>> arr, int rowSize, int colSize) {
        int sum = 0;
        for (int i = 0; i <= rowSize; i++) {
            for (int j = 0; j <= colSize; j++) {
                if ((i + j) == rowSize + 1)
                    sum += arr.get(i- 1).get(j - 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, -2, -3)));
        A.add(new ArrayList<>(List.of(-4, 5, -6)));
        A.add(new ArrayList<>(List.of(-7, -8, 9)));

        int rowSize = A.size();
        int colSize = A.get(0).size();

        ColSum colSum = new ColSum();
        ArrayList<Integer> res = colSum.getRowSum(A, rowSize, colSize);
        // res.forEach(System.out::println);
        int diagSum = colSum.getDiagonalSum(A, rowSize, colSize);
        System.out.println(diagSum);
        int miniDiag = colSum.findMinorDiagonalSum(A, rowSize, colSize);
        System.out.println(miniDiag);

    }
}
