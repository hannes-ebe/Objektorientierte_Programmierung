/**
 * class for managing trains. I like trains.
 */
public class Traincar {

    /***
     *
     * @param seats number of seats in this traincar
     */
    Traincar(int seats) {
        this.seats = seats;
        nextCar = null;
    }

    /**
     * number of seats in this train car
     */
    private int seats;
    /**
     * link to the next car
     */
    private Traincar nextCar;

    /**
     *
     * @param seats set the number of seats
     */
    public void setSeats(int seats){
        this.seats = seats;
    }

    /**
     *
     * @return the number of seats in this car
     */
    public int getSeats() {
        return seats;
    }

    /**
     *
     * @param next put the next Traincar behind the current
     */
    public void connectCar(Traincar next) {
        nextCar = next;
    }

    /**
     * remove the link to the next Traincar
     */
    public void disconnect() {
        nextCar = null;
    }

    /**
     *
     * @return the next Traincar if available, else null
     */
    public Traincar getNext() {
        return nextCar;
    }

    /**
     *
     * @return if a next Traincar is connected/exists after this car
     */
    public boolean hasNext() {
        return null != nextCar;
    }

    /**
     *
     * @return the capacity of the train starting with this car
     */
    public int capacity(){
        int sumSeats = getSeats();
        Traincar currentTraincar = this;
        while (currentTraincar.hasNext()) {
            currentTraincar = currentTraincar.getNext();
            sumSeats += currentTraincar.getSeats();
        }
        return sumSeats;
    }

    /**
     * add a train car directly behind this one
     * @param n number of seats
     */
    public void insertNext(int n){
        Traincar oldNextCar = getNext();
        connectCar(new Traincar(n));
        getNext().connectCar(oldNextCar); // connect current nextCar to oldNextCar
    }

}
