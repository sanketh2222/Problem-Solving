import java.util.ArrayList;
import java.util.List;

public class RotateMatrix {

    public void solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> transpose = takeTranspose(A);
        for (int i = 0; i < transpose.size(); i++) {
            ArrayList<Integer> reversedRow = reverseArray(transpose.get(i));
            transpose.set(i, reversedRow);

        }
        A = transpose;
        A.forEach(System.out::println);

    }

    public void inPlaceTranspose(ArrayList<ArrayList<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {
            for(int j = i + 1; j < A.size(); j++) {
                int temp = A.get(i).get(j);
                A.get(i).set(j, A.get(j).get(i));
                A.get(j).set(i, temp);
            }
        }
        // A.forEach(System.out::println);


    }

    public ArrayList<ArrayList<Integer>> takeTranspose(ArrayList<ArrayList<Integer>> A) {
        int rowSize = A.get(0).size();
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

    public ArrayList<Integer> reverseArray(ArrayList<Integer> arr) {
        int start = 0, end = arr.size() - 1;
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            end--;
            start++;
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, 2)));
        A.add(new ArrayList<>(List.of(3, 4)));
        // A.add(new ArrayList<>(List.of(7, 8, 9)));
        RotateMatrix matrix = new RotateMatrix();
        // matrix.solve(A);
        matrix.inPlaceTranspose(A);
        A.forEach(System.out::println);

    }
}
