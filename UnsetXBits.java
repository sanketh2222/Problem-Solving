public class UnsetXBits {

    public long solve(long A, int B) {
        int one = 1;
        while(B > 0){
          if ((A & one) == one){
              A = A ^ one;
          } 
          one = one << 1; 
          B-=1;
        }
        return A;
    }
    
    public static void main(String[] args) {
        UnsetXBits bits = new UnsetXBits();
        long ans = bits.solve(53, 5);
        System.out.println(ans);
        System.out.println(2<<1);
        
    }
}
