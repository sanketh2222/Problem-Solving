public class PrintWithRecursion {

    public static void solve(int A) {
        if (A == 0)
            return;
        
        solve(A - 1);
        System.out.print(A+ " ");
    }
    
    public static void main(String[] args) {
        PrintWithRecursion.solve(9);
        
    }
}
