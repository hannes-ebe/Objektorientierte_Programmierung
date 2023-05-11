public class ArrayExample {
    public static void main(String[] args) {
        // int = 5;
        int[] array = new int[5];

        array[2] = 3;
        int x = array[4];

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
