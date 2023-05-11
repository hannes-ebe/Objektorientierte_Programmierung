public class TestSchneckenrennen {
    public static void main(String[] args) {
        Rennschnecke karl = new Rennschnecke("Karl", "Weinbergschnecke", 22);
        Rennschnecke toni = new Rennschnecke("Toni", "Posthornschnecke", 22);
        Rennschnecke franz = new Rennschnecke("Franz", "Nacktschnecke", 22);

        Rennen pistonCup = new Rennen("Piston Cup", 3, 100000);
        pistonCup.addRennschnecke(karl);
        pistonCup.addRennschnecke(toni);
        pistonCup.removeRennschnecke("Karl");
        pistonCup.addRennschnecke(karl);
        pistonCup.addRennschnecke(franz);
        pistonCup.removeRennschnecke("Franz");
        pistonCup.addRennschnecke(franz);
        pistonCup.durchführen();

        System.out.print("Gewonnen hat: ");
        System.out.println(pistonCup.ermittleGewinner().getName());
        System.out.println(karl);
        System.out.println(toni);
        System.out.println(franz);
    }
}
