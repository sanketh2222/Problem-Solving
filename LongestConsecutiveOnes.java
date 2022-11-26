public class LongestConsecutiveOnes {

    public int solve(String A) {
        char[] bnaryArry = A.toCharArray();
        int oneCounts = 0;
        int count = 0;
        int ans = 0;
    
        for (int i = 0; i < bnaryArry.length; i++) {
            if (bnaryArry[i] == '1') {
                oneCounts++;
            }
        }
        for (int i = 0; i < bnaryArry.length; i++) {
            int leftOnes = 0;
            int rightOnes = 0;
            // count = 0;
            if (bnaryArry[i] == '0') {
                // count left side ones
                for (int j = i - 1; j >= 0; j--) {
                    if (bnaryArry[j] == '1') {
                        leftOnes++;

                    } else {
                        break;
                    }
                }

                // count right side ones
                for (int j = i+ 1 ; j < bnaryArry.length; j++){
                    if (bnaryArry[j] == '1') {
                        rightOnes++;
                    } else{
                        break;
                    }
                }

                count = leftOnes + rightOnes;

                if (count < oneCounts) { count+=1;}

                if (count > ans){ans = count;}

                


            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutiveOnes consecutiveOnes = new LongestConsecutiveOnes();
        String A = "111000";
        int ans  = consecutiveOnes.solve(A);
        System.out.println(ans);
    }
}
