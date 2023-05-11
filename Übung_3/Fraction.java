public class Fraction {
    //Wie genau soll der Umgang mit negativen Brüchen aussehen???
    private int numerator;
    private int denominator;
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        }
        else {
            //Soll ich hier den Zähler auch Null setzen, ähnlich wie in der Vorlesung?
            this.denominator = 1;
        }
    }
    public int getNumerator() {
        return this.numerator;
    }
    public int getDenominator() {
        return this.denominator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
        else {
            this.denominator = 1;
        }
    }
    public double value() {
        //Gibt den Wert des Bruchs als double zurück; Caste die ints vor dem Teilen zu doubles
        double val = (double) this.numerator / (double) this.denominator;
        return val;
    }
    public void expand(int x) {
        //Erweitert den Bruch um eine ganze Zahl
        this.numerator *= x;
        this.denominator *= x;
    }
    private static int calcGCD(int x, int y) {
        //  Nutze Euklidischen Algorithmus, Überprüfe welche Zahl größer ist.
        // Sind beide Zahlen gleich groß, ist die Zahl selbst ggT
        // Implementiert wie C-Version von Wikipedia.
        // Divisor bei Rest 0 ist der ggT
        if (x == 0) {
            return Math.abs(y);
        }
        if (y == 0) {
            return Math.abs(x);
        }
        int remainder;
        do {
            remainder = x % y;
            x = y;
            y = remainder;
        } while (remainder != 0);
        return Math.abs(x);
    }
    public void shorten() {
        //Kürzt den Bruch soweit es geht. Bei negativen Brüchen steht das Vorzeichen nach dem Kürzen im Zähler.
        int gcd = Fraction.calcGCD(this.numerator, this.denominator);
        int newNumerator = this.numerator/gcd;
        int newDenominator = this.denominator/gcd;
        if ((newNumerator < 0 & newDenominator > 0) || (newNumerator > 0 & newDenominator > 0)) {
            this.numerator = newNumerator;
            this.denominator = newDenominator;
        }
        else if (newNumerator > 0 & newDenominator < 0){
            this.numerator = -newNumerator;
            this.denominator = Math.abs(newDenominator);
        }
        else {
            this.numerator = Math.abs(newNumerator);
            this.denominator = Math.abs(newDenominator);
        }
    }
    public String toString() {
        // Gibt eine sinnvolle textuelle Beschreibung des Bruchs zurück.
        String description = this.numerator + "/" + this.denominator;
        return description;
    }
    public void addMut(final Fraction x) {
        // Addiert einen anderen Bruch hinzu und kürzt das Ergebnis.
        int xNumerator = x.getNumerator();
        int xDenominator = x.getDenominator();
        int valNumerator = this.numerator * xDenominator + xNumerator * this.denominator;
        int valDenominator = this.denominator * xDenominator;
        this.numerator = valNumerator;
        this.denominator = valDenominator;
        this.shorten();
    }
    public void multMut(final Fraction x) {
        // Multiplikation mit einem anderen Bruch, hier darf nicht gekürzt werden.
        int xNumerator = x.getNumerator();
        int xDenominator = x.getDenominator();
        this.numerator *= xNumerator;
        this.denominator *= xDenominator;
    }
    public int compareTo(final Fraction x) {
        // Gibt -1 zurück, wenn x kleiner ist, 0 wenn gleich und 1 wenn x größer ist.
        // Kann x nicht kürzen...
        // Multipliziere den Zähler jeweils mit dem Nenner des anderen Bruchs.
        // Dann kann ich vergleichen (entspricht Erweitern auf gleichen Nenner)
        int a = this.numerator * x.getDenominator();
        int b = x.getNumerator() * this.denominator;
        if (a < b) {
            return 1;
        }
        else if (a > b) {
            return -1;
        }
        else {
            return 0;
        }
    }
    public static void swap(Fraction a, Fraction b) {
        /*
        Fraction c = a;
        a = b;
        b = c;
        */
        int ayuda = a.getNumerator();
        a.setNumerator(b.getNumerator());
        b.setNumerator(ayuda);

        ayuda = a.getDenominator();
        a.setDenominator(b.getDenominator());
        b.setDenominator(ayuda);
    }
}
