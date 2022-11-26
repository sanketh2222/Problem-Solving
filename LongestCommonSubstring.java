public class LongestCommonSubstring {

    public String longestCommonPrefix(String[] A) {
        StringBuffer buffer = new StringBuffer();
        int[] countArr = new int[26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].toCharArray().length; j++) {
                countArr[A[i].toCharArray()[j] - 'a']++;
            }
        }
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] != 3)
                break;
            else buffer.append((char)(i + 'a'));
        }
        return buffer.toString();
    }

    // private void calculateFrequency(String str){

    // }

    public static void main(String[] args) {
        LongestCommonSubstring commonSubstring = new LongestCommonSubstring();
        String[] A = {"abab", "ab", "abcd" };
        String ans  = commonSubstring.longestCommonPrefix(A);
        System.out.println(ans);

    }
}
