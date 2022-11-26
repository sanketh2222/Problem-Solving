public class CountOccurences {

    public static int solve(String A) {
        int count = 0;
        for (int i =0 ; i < A.length() - 2; i++){
            if (A.substring(i, i+ 3).equals("bob")){
                count+=1;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int ans = CountOccurences.solve("bobob");
        System.out.println(ans);
        
    }
}
