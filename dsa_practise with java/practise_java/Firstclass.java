
import java.util.Scanner;
class Firstclass{
    public static void main(String args[]){
        // System.out.println("hello world");
        // //taking an input from user
        // int ans = sum2();
        // System.out.println(ans);

        int answer = sum3(20, 30);
        System.out.println(answer);
    
    }

    //passs the value of numbers when you are calling the method in main() using parameters
    static int sum3(int a, int b) {
        int c = a + b;
        return c;
    }

    static int sum2() {
        Scanner in =new Scanner(System.in);
        int a, b, c;
        System.out.print("enter first number:");
        a=in.nextInt();
        System.out.print("enter second number:");
        b=in.nextInt();
        c=a+b;
        return c;
    }

    static void sum() {
        Scanner in =new Scanner(System.in);
        int a, b, c;
        System.out.print("enter first number:");
        a=in.nextInt();
        System.out.print("enter second number:");
        b=in.nextInt();
        c=a+b;
        System.out.print("the sum is:"+c);
    }
}