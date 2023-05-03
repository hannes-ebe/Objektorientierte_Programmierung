public class Zinsrechner {
    private double startKapital;
    private double zinsSatz;
    private double endKapital;
    private int jahre;
    private final static double MILLION = 1000000.0;
    public void setCapital(double capital) {
        this.startKapital = capital;
    }
    public void setInterest(double interest) {
        this.zinsSatz = interest;
    }
    public void setEndCapital(double endCapital) {
        this.endKapital = endCapital;
    }
    public void setYears(int years) {
        this.jahre = years;
    }
    // Setter für die Konstante MILLION ergibt keinen Sinn...
    public double getCapital() {
        return this.startKapital;
    }
    public double getInterest() {
        return this.zinsSatz;
    }
    public double getEndCapital() {
        return this.endKapital;
    }
    public int getYears() {
        return this.jahre;
    }
    public double getMillion() {
        return this.MILLION;
    }
    public int berechneJahre() {
        int counter = 0;
        // Muss noch 1 zum Zinssatz addieren...
        double factor = 1.0 + this.getInterest();
        for (double money = this.getCapital(); money < this.getMillion(); money *= factor) {
            counter++;
        }
        return counter;
    }
}
