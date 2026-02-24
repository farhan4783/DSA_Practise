public class shadowing {
    static int x = 10;
    public static void main(String[] args) {
        System.out.println(x);
        
        int x = 20; // this will shadows the static variable x
        System.out.println(x);

        fun();
    }

    static void fun() {
        System.out.println(x);
    }
}
