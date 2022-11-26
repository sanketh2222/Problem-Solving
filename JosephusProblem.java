public class JosephusProblem {
    
    
    public static void main(String[] args) {
        int A = 8;
        int closestPower = 1;
        int n = 1;
        while ( n < A){
            n = n * 2;
            if (n < A){
                closestPower = n;
            }
             
        }
        System.out.println(closestPower);
        
    }
}
