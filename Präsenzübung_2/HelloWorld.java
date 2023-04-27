public class HelloWorld {
    public static void main(String[] args) {
        int i;
        i = 1;

        for (int j = 0; j < 3; j++) {
            System.out.println(Integer.toString(j));
        }

        switch (i) {
            case 1: System.out.println("Case 1"); break;
            case 4: System.out.println("Case 2");
        }

        System.out.println("Hello World");
        System.out.println("This is a number: " + Integer.toString(i));
    }
}
