import java.util.Random;
import java.lang.Math;

public class Rennschnecke {
    private String name;
    private String race;
    private double maxSpeed;
    private double coveredDistance;

    public Rennschnecke(String name, String race, double maxSpeed) {
        this.name = name;
        this.race = race;
        this.maxSpeed = maxSpeed;
    }
    public String getName() {
        return this.name;
    }
    public double getCoveredDistance() {
        return this.coveredDistance;
    }
    public void krieche() {
        // Lässt Schnecke zufälligen Wert kleiner maxSpeed in positive oder negative Richtung kriechen (Zeiteinheit 1).
        double rand = Math.random() * this.maxSpeed;
        // True ist die positive Richtung und False die negative Richtung.
        Random random = new Random();
        boolean direction =  random.nextBoolean();
        if (direction) {
            this.coveredDistance += rand * this.maxSpeed;
        }
        else {
            this.coveredDistance -= rand * this.maxSpeed;
        }
    }
    public String toString() {
        return this.race + " " + this.name + " hat die maximale Geschwindigkeit " + this.maxSpeed + " und eine Strecke von " + this.coveredDistance + " zurückgelegt.";
    }
}
