import java.util.ArrayList;
import java.util.List;

public class FindAllSubArrays {

    public ArrayList<ArrayList<Integer>> findSubArrays(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> allSubArraysList = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = i; j < A.size(); j++) {
                addSubArray(A, i, j, allSubArraysList);
            }
        }
        return allSubArraysList;
    }

    public void addSubArray(ArrayList<Integer> A, int start, int end, ArrayList<ArrayList<Integer>> allSubArraysList) {
        ArrayList<Integer> subArray = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            subArray.add(A.get(i));
        }
        allSubArraysList.add(subArray);
    }

    public static void main(String[] args) {
       FindAllSubArrays allSubArrays = new FindAllSubArrays();
       List<Integer> lst = List.of(5, 2, 1, 4);
       ArrayList<ArrayList<Integer>> result = allSubArrays.findSubArrays(new ArrayList<>(lst));
       result.forEach(System.out::println);
    }
}
