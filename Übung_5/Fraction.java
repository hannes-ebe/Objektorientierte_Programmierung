/**
 * @brief  Class Fraction for fractions (rational numbers)
 *
 */
class Fraction {


    private int numerator; // numeraterator
    private int denominator; // denominator

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int num) {
        numerator = num;
        denominator = 1;
    }

    public Fraction(int num, int den) {
        numerator = num;
        denominator = den;
        if (denominator == 0) {
            numerator = 0;
            denominator = 1;
        }
    }

    /**
     * @return the numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * setter method for field numerator
     *
     * @param numerator the numerator to set
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * @return the denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * @param denominator the denominator to set
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    /**
     * The floating point value of the fraction
     *
     * @return
     */
    public double value() {
        if (denominator != 0) {

            return (double) numerator / denominator;
        } else {
            return numerator;
        }
    }

    /**
     * Expands the fraction by x
     *
     * @param x
     */
    public void expand(int x) {
        numerator *= x;
        if (x != 0) {
            denominator *= x;
        }
    }

    /**
     *
     * @param a
     * @param b
     * @return the ggt
     */
    private static int ggt(int a, int b) {
        int ggt = 0;
        if (a == b) {
            ggt = b;
        } else {
            while (b != 0) {
                if (a > b) {
                    a = a - b;

                } else {
                    b = b - a;
                }
            }
            ggt = a;
        }
        return ggt;
    }

    /**
     * shortens the fraction
     */
    public void shorten() {
        // minus
        if (numerator < 0 && denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        } else if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        // ggt see exercise 2
        int ggtValue = ggt(Math.abs(numerator), denominator);
        numerator /= ggtValue;
        denominator /= ggtValue;
    }

    /**
     * @return a String representation of this Fraction
     */
    public String toString() {
        return (numerator + " / " + denominator);
    }


    /**
     * Addition operations, shortens the Fraction.
     * @param x add this fraction to this
     *
     */
    public void addMut(final Fraction x) {

        // expand
        numerator *= x.denominator;
        int otherN = x.numerator * denominator;
        denominator *= x.denominator;
        // add
        numerator += otherN;
        // shorten
        shorten();
    }


    /**
     * @param x multiplier for inplace multiply
     */
    public void multMut(final Fraction x) {
        numerator *= x.numerator;
        denominator *= x.denominator;
    }


    /**
     * @param x the Fraction this Fraction is compared to
     * @return int  0 if x == this, 1 if x > this , -1 if x < this
     */
    public int compareTo(final Fraction x) {
        double v = value();
        double xv = x.value();
        if (xv < v) {
            return -1;
        }
        if (xv > v) {
            return 1;
        }
        // if(v == xv)
        return 0;
    }

    /**
     * Swaps two fractions
     * @param a first fraction
     * @param b second fraction
     */
    public static void mutSwap(Fraction a, Fraction b) {
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
    public static void sortFractions(Fraction[] list) {
        //ToDo Welchen Sortieralgorithmus nutzen???
    }
}