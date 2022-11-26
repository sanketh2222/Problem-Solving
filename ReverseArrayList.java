import java.util.ArrayList;
import java.util.List;

public class ReverseArrayList {

    public static void reverseArray(ArrayList<Integer> arr) {
        int start = 0, end = arr.size() - 1;
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            // arr.remove(arr.get(start));
            arr.set(end, temp);
            // arr.remove(arr.get(end));
            end--;
            start++;
        }
        // arr.forEach(System.out::println);
    }

    public static void changeArray(Integer[] arr ){
        arr[0] = 100;

    }

    public static void main(String[] args) {
        List<Integer> lst = List.of(1, 2, 3, 4);
        reverseArray(new ArrayList<>(lst));

        Integer[] arr = lst.toArray(new Integer[lst.size()]);
        // changeArray(arr);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
    }
}
