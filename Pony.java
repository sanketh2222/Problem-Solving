import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pony {

    private static ArrayList<Integer> result;

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Integer[] mobilePrices = A.toArray(new Integer[A.size()]);
        Integer[] moneyAmounts = B.toArray(new Integer[B.size()]);

        ArrayList<Integer> resultant = new ArrayList<>();
        for (int i = 0; i < moneyAmounts.length; i++) {
            int balance = moneyAmounts[i], purchaseCount = 0, mobilePricesIndex = 1;
            int mobilePrice = mobilePrices[0];
            while (balance > mobilePrice && mobilePricesIndex <= A.size() && purchaseCount < mobilePrices.length) {
                balance -= mobilePrice;
                purchaseCount += 1;
                if (mobilePricesIndex < A.size())
                    mobilePrice = mobilePrices[mobilePricesIndex++];
                
            }
            resultant.add(purchaseCount);
        }
        return resultant;
    }

    public static void main(String[] args) {
        // [3,4,4,6]
        List<Integer> mobilePrices = Arrays.asList(25, 43, 47, 95, 98);

        List<Integer> moneyAmounts = Arrays.asList(184, 533, 811, 330, 509, 192);

        result = solve(new ArrayList<>(mobilePrices), new ArrayList<>(moneyAmounts));

        result.forEach(System.out::println);
    }
}
