public class TimeComp {

    private static void func(int n) {
        for (int i = 1; i <= 100; i *= 2) {
            System.out.println(i);
            for (int j = 1; j <= n; j++) {

                // System.out.println((i + j));

            }

        }
    }

    private static void func1(int n) {
        for(int i=1,j=1; j <= n; i++) {
            System.out.println(i+j);
        }
    }

    private static void fucn2(int n) {
        int i = 0;
        while (i*i < n) {
            System.out.println(i);
            for(int j = 0; j <= n; j++) {
                for(int k=0; k <= n; k++,i++) {
                    System.out.println(" "+i+" "+j+" "+k+" ");
                }
            }
            // i++;
        }
    }

    private static void func3(int n) {
        int count = 0;
        for (int i = n; i > 0; i/= 2) {
            // System.out.println(i);
            for (int j = 0; j < i; j++) {
                count+=1;
            }
        }
        System.out.println(count);
        
    }

    public static void main(String[] args) {
        // func(10);
        // func1(5);
        // fucn2(10);
        func3(10);
    }
}
