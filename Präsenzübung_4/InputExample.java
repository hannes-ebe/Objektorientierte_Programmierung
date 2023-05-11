import java.util.*;
public class InputExample {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Gib ein Wort ein: ");
        String s;
        s = scan.nextLine();
        System.out.print("Gib eine Zahl ein: ");
        int i = scan.nextInt();

        // Stream wird geschlossen.
        scan.close();

        System.out.println(s);
        System.out.println(i);
    }
}
