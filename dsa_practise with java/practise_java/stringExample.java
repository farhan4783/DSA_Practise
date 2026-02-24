import java.util.Scanner;

public class stringExample {
    public static void main(String[] args) {

        // String message = greet();
        // System.out.println(message);
        Scanner in = new Scanner(System.in);
        System.out.println("enter your name:");
        String name = in.next();
        String personalised =  myGreet(name);
        System.out.println(personalised);

    }

    static String myGreet(String name) {
        String message = name + " ,How are you?";
        return message;
    }


    static String greet() {

        String greeting = "How are you?";

        return greeting;
    }
    
}
