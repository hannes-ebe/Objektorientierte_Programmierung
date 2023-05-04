public class EnumsTest {
    enum Level {
        HIGH,
        MEDIUM,
        LOW
    }
    public static void main(String[] args) {
        Level medium = Level.MEDIUM;
        System.out.println(medium);
        System.out.println(medium == Level.LOW);
    }
}
