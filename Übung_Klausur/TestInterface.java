public class TestInterface implements Increasable {

    public int increaseInteger(int i) {
        return ++i;
    }
    public void increaseInterfaceInteger() {
        // integer ist automatisch final
        // integer += 1;
    }
    public int getInteger() {
        return this.integer;
    }
    public static void main(String[] args) {
        int i = 0;

        // integer automatisch static
        System.out.println(integer);

        TestInterface test = new TestInterface();

        System.out.println(test.increaseInteger(i));
        System.out.println(test.defaultIncreaseInteger(i));
        System.out.println(test.getInteger());
    }
}
