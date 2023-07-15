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

        enum Color {RED, GREEN, BLUE, YELLOW}
        // Color textColor = Color.BLACK;
        // Color textColor = Color.BLUE;
        final Color textColor = Color.GREEN;
        System.out.println(new ArrayList<Color>().size());
        System.out.println(textColor);
    }
}
