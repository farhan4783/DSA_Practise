public class Overloading {
    public static void main(String[] args) {
        fun(20);
        fun("Hello");
        int ans = sum(20,98);
        System.out.println(ans);
        int num = sum(20,98,100);
        System.out.println(num);
        
    }
    static int sum(int a, int b) {
        return a + b;
    }
    static int sum(int a, int b, int c) {
        return a + b + c;
    }

    static void fun(int a) {
        System.out.println(a);
    }

    static void fun(String a) {
        System.out.println(a);
    }
}
