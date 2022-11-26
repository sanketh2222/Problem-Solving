import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;

public class SortByColor {

    public class ColorSorter implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1.intValue() > o2.intValue())
                return 1;
            else if (o1.intValue() < o2.intValue())
                return -1;
            return  0;
        }
        
    }

    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        SortByColor sortByColor = new SortByColor();
        // Collections.sort(A,sortByColor.new ColorSorter());
        

        //Below is Java8 way of sorting
        return new ArrayList<>(A.stream().sorted(new ColorSorter()).collect(Collectors.toList()));
    }
    
    public static void main(String[] args) {
        
        SortByColor sortByColor = new SortByColor();
        // sortByColor.sortColors(new ArrayList<>(Arrays.asList(0, 1, 2, 0, 1, 2))).forEach(System.out::println);
        List<String> arr = Arrays.asList("Sanketh S","Sanketh D");
        arr.sort((name1,name2) -> name1.compareTo(name2));
        arr.forEach(System.out::println);
    }
}
