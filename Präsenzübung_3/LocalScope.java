import java.io.*;
public class LocalScope {
    public static void main(String[] args) {
        int result = 5;
        for (int a = 0; a < 5; a++)
        {
            // Kompiliert nicht mit der nächsten Zeile, da result bereits deklariert ist in der Scope.
            // int result = 6;
            System.out.println(a);
        }
        System.out.println(result);
    }
}
