public class TestZinsrechner {
    public static void main(String[] args) {
        Zinsrechner rechner = new Zinsrechner();
        rechner.setCapital(10000);
        rechner.setInterest(0.079);

        int berechneteJahre = rechner.berechneJahre();
        System.out.println(berechneteJahre);
    }
}
