public class Swap {
    public static void main(String[] args) {
        int a =20;
        int b = 30; 
        swap(a, b);
        System.out.println("After swapping: a = " + a + ", b = " + b);

    }

    //Swapping 2 numbers using methods
    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        // this change will not reflect in main method

    }



}
