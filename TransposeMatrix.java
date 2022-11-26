import java.util.ArrayList;
import java.util.List;

public class TransposeMatrix {

    public ArrayList<ArrayList<Integer>> findTranspose(ArrayList<ArrayList<Integer>> A) {
        int rowSize  = A.get(0).size();
        int colSize = A.size();
        for (int i = 0; i < rowSize; i++) {
            for (int j = i + 1; j < rowSize; j++) {
                int temp = A.get(i).get(j);
                int element = A.get(j).get(i);
                A.get(i).remove(j);
                A.get(i).add(j, element);//A[i][j] = A[j][i]
                A.get(j).remove(i);
                A.get(j).add(i,temp);//A[j][i] = temp
            }
        }
        return A;
    }

    public ArrayList<ArrayList<Integer>> findTransposeForRectangualarMatrix(ArrayList<ArrayList<Integer>> A){
        int rowSize  = A.get(0).size();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int colSize = A.size();
     
        for (int i = 0; i < rowSize; i++) {
            ArrayList<Integer> col = new ArrayList<>();
            for (int j = 0; j < colSize; j++) {
                col.add(A.get(j).get(i));
            }
            arr.add(col);
        }

        return arr;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, 2, 3)));
        A.add(new ArrayList<>(List.of(4, 5, 6)));
        A.add(new ArrayList<>(List.of(7, 8, 9)));
        TransposeMatrix matrix = new TransposeMatrix();
        ArrayList<ArrayList<Integer>> result = matrix.findTransposeForRectangualarMatrix(A);
        // A.get(0).remove(2);
        // A.get(0).add(2,10);
        result.forEach(System.out::println);

    }
}
