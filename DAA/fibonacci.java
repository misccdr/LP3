public class fibonacci{
    public static int fibRecursion(int count) {
        if (count == 0) {
          return 0;
        } 
        if (count == 1 || count == 2) {
          return 1;
        } 
        return fibRecursion(count - 1) + fibRecursion(count - 2);
      }

    public static void fibNonRecur(int n) {
        int a = 0;
        int b = 1;
        System.out.println("\nFibonacci Sequence by ITERATIVE METHOD");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            int sum = a + b;
            a = b;
            b = sum;
        }
    }

    public static void main(String args[]) {
        int fib_len = 6;
        System.out.print("Fibonacci Series by RECURSION:\n");
        for (int i = 0; i < fib_len; i++) {
          System.out.print(fibRecursion(i) + " ");
        }
        fibNonRecur(fib_len);
      }
}