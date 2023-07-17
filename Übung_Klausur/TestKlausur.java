import java.util.ArrayList;

public class TestKlausur {
    public static void main(String args[]) {
        int i = 0;
        // System.out.println(++i * 2.0);
        // System.out.println((double)(int)3.2*2);
        // System.out.println(1/2 * 3");
        // i = 0.0;
        // System.out.println(i);

        /*
        int[][] a;
        int[][] b = {{1,2},{3,4}};
        a = b;
        System.out.println(a.length + a[0].length);
        a[0][0] = 5;
        System.out.println(a[0][0] + b[0][0]);
        System.out.println(a[0][0] + b[0][1]);
        */

        /*
        enum Color {RED, GREEN, BLUE, YELLOW}
        // Color textColor = Color.BLACK;
        // Color textColor = Color.BLUE;
        final Color textColor = Color.GREEN;
        System.out.println(new ArrayList<Color>().size());
        System.out.println(textColor);
         */


        // System.out.println(1 / 2 + 3);
        // i = 0.0;
        // System.out.println(i);
        // System.out.println(Float.MIN_VALUE < Integer.MIN_VALUE);
        // System.out.println(Float.MIN_VALUE);
        // System.out.println(Integer.MIN_VALUE);
        // System.out.println(i++ * 4 + ++i * 2.0);
        // System.out.println((double) (int) 4.1 * 2);


        /*
        int[][] a;
        int[][] b = {{4,1,2},{7,3,9}};
        a = b;
        int c = a.length + a[0].length;
        System.out.println(c);
        a[0][0] = 5;
        System.out.println(a[0][0]);
        a[0][0] = a[0][0] + b[0][0];
        System.out.println(a[0][0]);
        a[0][0] = a[0][1] + b[1][1];
        System.out.println(a[0][0]);
        */


        // PizzaTopping topping = PizzaTopping.CHEESE;
        // PizzaTopping topping = PizzaTopping.FUNGI;

        String newString;
        String newString2 = "Hello";
        newString = newString2;
        System.out.println(newString);
        System.out.println(newString2);

    }
    enum PizzaTopping { ONIONS, PEPPERS, FUNGI}
    void handleTopping(PizzaTopping topping) {
        if (topping == PizzaTopping.ONIONS) {
            topping = PizzaTopping.FUNGI;
        }
    }
}
