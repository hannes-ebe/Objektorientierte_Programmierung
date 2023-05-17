/**
 * Class for testing Traincar
 */
public class TraincarTest {
    public static void main(String[] args) {
        Traincar zug = new Traincar(25);
        zug.connectCar(new Traincar(75));
        zug.getNext().connectCar((new Traincar(48)));
        System.out.println(zug.capacity());
        zug.getNext().insertNext(52);
        System.out.println(zug.capacity());
        System.out.println(zug.getNext().getNext().getSeats());
    }
}
