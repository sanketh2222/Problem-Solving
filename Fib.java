public class Fib {

    // Dynamic programming cache
    private static int fib(int n) {
        int fibArray[] = new int[n + 1];

        if (n == 0 || n == 1) {
            return 1;
        } else if (fibArray[n] != 0) {
            return fibArray[n];
        } else {
            return fibArray[n] = fib(n - 1) + fib(n - 2);
        }

    }

    private static int fibonacci(int n) {
        int fibArray[] = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] =1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            fibArray[i] += fibArray[i-1]+fibArray[i-2];
        }
        System.out.println(fibArray);
        return 0;
    }

    public static void main(String[] args) {
        int res = fib(5);
        System.out.println(res);
        System.out.println(fibonacci(5));

    }
}
