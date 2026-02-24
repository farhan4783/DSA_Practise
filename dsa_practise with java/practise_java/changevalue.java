import java.util.Arrays;

public class changevalue {
    public static void main(String[] args) {
        //create a array
        int[] arr = {1, 3, 2, 4, 5, 6};
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void change(int[] num) {
        num[0] = 99;// if you make a change to object here it will reflect in main method
    }
}
