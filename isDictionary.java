import java.util.HashMap;
import java.util.Map;

public class isDictionary {

    public static int solve(String[] A, String B) {
        Map<Character, Integer> dictMap = new HashMap<>();
        int charValue = 0;
        for (char ch : B.toCharArray()) {
            dictMap.put(ch, charValue++);
        }
        
        for (int i = 0; i < A.length - 1; i++) {
                if (!compare(A[i], A[i + 1], dictMap)){
                    return 0;
                }
        }
        return 1;

    }

    public static boolean compare(String s1, String s2,Map<Character,Integer> dictMap) {
        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (dictMap.get(s1.charAt(i)) > dictMap.get(s2.charAt(j))) {
                return false;
            } else if (dictMap.get(s1.charAt(i)) < dictMap.get(s2.charAt(j))) {
                return true;
            } else {
                i++;
                j++;
            }
        }
        return i == s1.length() ? true : false;
    }

    public static void main(String[] args) {
       String[] A = {"hello", "scaler", "interviewbit"};
       String B = "adhbcfegskjlponmirqtxwuvzy";
       int ans = isDictionary.solve(A, B);
       System.out.println(ans);

    }
}
