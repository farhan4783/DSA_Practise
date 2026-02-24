public class Scope {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        String name = "Java";
        {
            a = 78;
            System.out.println(a);
            
            name = "Python";
            System.out.println(name);


            // int a = 90; cannot reinitialise a variable with same name in same scope
            int c = 99;// values initialised in this block will remain in this block

            a = 1000;
        }
        System.out.println(a);
        // System.out.println(c);cannot be used out sidethe block

        //scopping in for loop
        // for (int i = 0; i < 5; i++) {
        //     System.out.println(i);
        //     int num = 90;
        // }

        /// anything which is initialised in the block will remain in the block only
        /// anything which is initialised outside the block can be used inside the block
        /// in the block anything which is initialised can be reinitialised outside the block.
    }
}
