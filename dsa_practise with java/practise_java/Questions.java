

public class Questions {
    public static void main(String[] args) {
    //  Scanner in = new Scanner(System.in);
    //  int n = in.nextInt();
     for (int i = 100; i < 1000; i++) {
         if (isArmstrong(i)) {
             System.out.print(i + " ");
         }
     }
    //  boolean ans = isPrime(n);
    //  System.out.println(ans);
    //  System.out.println("check if the nuber is armstong number or not");
    //  armstrong(n);
        
    }

    //Print all the three digit armstrong numbers
    static void armstrong(int a){
        int cube, rem, sum = 0;

        while (a > 0){
            rem = a % 10;
            cube = rem * rem * rem;
            sum += cube;
            a = a/10;
            
        }
        if (sum == a){
            System.out.println("Armstrong number");
        }
        else {
            System.out.println("Not an armstrong number");
        }
    }



    // static boolean isPrime(int n) {
    //     if (n <= 1){
    //         return false;
    //     }
    //     int c = 2;
    //     while (c * c <= n) {
    //         if (n % c == 0) {
    //             return false;
    //         }
    //         c++;
    //     }
    //    return c * c > n;
    // }

    //Sirs code for armstrong number
    static boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;

        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem * rem;
            n = n / 10;
        }
        return sum == original;
    }
    

}
