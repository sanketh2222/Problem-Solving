import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByFactor {

    public class FactorsSort implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            int factor1 = getNoOfFactors(o1.intValue());
            int factor2 = getNoOfFactors(o2.intValue());
            if (factor2 > factor1)
                return -1;
            else if (factor1 > factor2)
                return 1;
            else if ((factor1 == factor2) && (o1.intValue() > o2.intValue()))
                return 1;
            else
                return -1;
        }
    }

    

    private int getNoOfFactors(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if ((i == Math.sqrt(n) && (n % i == 0))) {
                count += 1;
            } else if (n % i == 0) {
                count += 2;
            }

        }
        return count;

    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 4, 7);
        // FactorsSort factorsSort = new FactorsSort();
        SortByFactor sortByFactor = new SortByFactor();
        sortByFactor.new FactorsSort();
        // SortByFactor.FactorsSort fs = new FactorsSort();
        // SortByFactor.FactorsSort factorsSort = new FactorsSort();
        Collections.sort(arr, sortByFactor.new FactorsSort());
        arr.forEach(System.out::println);
        // int ans = sortByFactor.getNoOfFactors(24);
        // System.out.println(ans);

    }
}
