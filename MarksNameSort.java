import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MarksNameSort {

    public class MarksNameSorted implements Comparator<String> {

        @Override
        public int compare(String o1,String o2) {
            String marksFromString1 = o1.replaceAll("[^0-9]","");
            String marksFromString2 = o2.replaceAll("[^0-9]","");
            int marks1 = Integer.parseInt(marksFromString1);
            int marks2 = Integer.parseInt(marksFromString2);
            if (marks1 > marks2){
                return -1;
            } else {
                return 0;
            }
        }

    }

    public String[] solve(String[] A) {
        String arr[] = { "kdhv3", "x3", "shivam96" };

        List<String> res = Arrays.stream(arr).sorted(new MarksNameSorted()).collect(Collectors.toList());
        return null;
    }

    public static void main(String[] args) {
        MarksNameSort marksNameSort = new MarksNameSort();
        marksNameSort.solve(null);

    }
}
