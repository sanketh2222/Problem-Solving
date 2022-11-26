import java.util.*;

public class CommonListElements {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer num : B) {
            if (freqMap.containsKey(num)) {
                int count = freqMap.get(num);
                freqMap.put(num, ++count);
            } else {
                freqMap.put(num, 1);
            }
        }

        for (Integer num : A) {
            if (freqMap.containsKey(num)) {
                // if (result.contains(num) && freqMap.get(num) % 2 == 0) {
                // result.add(num);
                // } else if (!result.contains(num)) {
                // result.add(num);
                // }
                int count = freqMap.get(num);
                count -= 1;
                result.add(num);
                if (count == 0)
                    freqMap.remove(num);
                else
                    freqMap.put(num, count);

            }

        }

        return result;
    }
    

    public static void main(String[] args) {
        CommonListElements commonElements = new CommonListElements();
        List<Integer> A = Arrays.asList(2, 1, 4, 10);
        List<Integer> B = Arrays.asList(3, 6, 2, 10, 10);
        ArrayList<Integer> ans = commonElements.solve(new ArrayList<>(A), new ArrayList<>(B));
        ans.forEach(System.out::println);

        Set<Integer> hashSet = new HashSet<>();
        System.out.println(hashSet.add(1));
        System.out.println(hashSet.add(1));
        hashSet.contains(0);

    }
}
