public class Fraction {
    /** The numerator of the fraction. */
    private int num;
    /** The denominator of the fraction. */
    private int denom;

    /**
     * Constructs a fraction and creates the fraction 0/1 if
     * the denominator is 0.
     */
    Fraction(int num, int denom) {
        if (denom == 0) {
            num = 0;
            this.denom = 1;
            this.num += 1;
            System.out.println(this.num);
            System.out.println(num);
        } else {
            this.num = num;
            this.denom = denom;
        }
    }

    /**
     * Adds another fraction by mutating the current fraction.
     * @param x The other fraction to add to this fraction.
     */
    public void addMut(Fraction x) {
        this.num = this.num * x.denom + x.num * this.denom;
        this.denom *= x.denom;
    }

    /**
     * Multiplies another fraction to this fraction
     * by mutating the current fraction.
     * @param x The other fraction.
     */
    public void multMut(Fraction x) {
        this.denom *= x.denom;
        this.num = this.num * x.num;
    }

    /**
     * Sets the denominator to the given value.
     * @param denom The new denominator.
     * @throws Exception if given denominator is 0.
     */
    public void setDenominator(int denom) throws Exception {
        if (denom == 0)
            throw new Exception("zero denominator");
        this.denom = denom;
    }

    public String toString() {
        return "Fraction " + num + "/" + denom;
    }

    public static void main(String[] args) {
        Fraction a = new Fraction(1, 3);
        Fraction b = new Fraction(2, 3);
        Fraction c = new Fraction(2,0);
        a.multMut (b); // 1/3 * 2/3 = 2/9
        a.addMut(b); // 2/9 + 2/3 = 24/27
        //a.multMut(c); // 24/27 * 2/1 = 48/27
        System.out.println(a);
        System.out.println(c);
        try {
            a.setDenominator(2);
            System.out.println(a);
            a.setDenominator(0);
            System.out.println(a);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
