import java.lang.Math;
import java.util.ArrayList;

public class Prime {
    private static boolean almstrong;

    public int solve(int A) {
        int primeCount = 0;
        for(int i=2;i <=A;i++){
            if(isPrime(i)){
                primeCount+=1;
                System.out.println(i);
            }
                
        }

        return primeCount;
    }

    public boolean isPrime(int n){
        int count = 0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if (n%i== 0){
                if (i*i == n) count++;
                else count+=2;
            }  
        }
        System.out.println(count);
        if (count == 2)
                return true;
        return false;
    }

    public static boolean isAlmstrong(int A){
        int num = 0,total = 0,temp = 0;
        temp = A;
        while(temp!=0){
            num = temp % 10;
            total+= num * num * num;
            temp = temp / 10;

            
        }
        return total == A;
    }

    public static int test(int A) {
        int totalSum = 0;
        for(int i = 1;i < A; i++){
            if ((A % i == 0))
                totalSum += i;
        }
        if (totalSum == A)
            return 0;
        return 1;
    }

    public static void main(String[] args) {
        Prime prime = new Prime();
        // System.out.println(prime.solve(10));
        // System.out.println(prime.isPrime(4));
        //declare arraylist
        // int a = 1;
        // ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // arrayList.add(a);
        // arrayList.add(2);
        // almstrong = isAlmstrong(153);
        // System.out.println(almstrong);
        test(2);
  
    }
}
