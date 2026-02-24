import java.util.Arrays;

public class varargs {
    public static void main(String[] args) {
        fun(2,3,4,5,6,7,20);
        fun();
        multiple(2, 3, "farhan");
        
    }

    static void multiple(int a, int b, String ...v) {

    }

    static void fun(int ...v) {
        System.out.println(Arrays.toString(v));
        System.out.println("Number of arguments: " + v.length);
    }

    static void demo (int ...v){
        
    }
}
