public interface Increasable {
    int integer = 0;
    // int integer;
    public int increaseInteger(int i);
    public default int defaultIncreaseInteger(int i) {
        return ++i;
    }
}
