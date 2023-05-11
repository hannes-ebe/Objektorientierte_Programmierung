public class TestFraction {
    public static void main(String[] args) {
        /*
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(3,4);
        System.out.println("Zähler f1: " + f1.getNumerator());
        System.out.println("Nenner f2: " + f2.getDenominator());
        f2.setDenominator(3);
        System.out.println("Nenner f2: " + f2.getDenominator());
        f2.setDenominator(0);
        System.out.println("Nenner f2: " + f2.getDenominator());
        System.out.println("f1 als double: " + f1.value());
        System.out.println("f2 als double: " + f2.value());
        f1.expand(2);
        System.out.println("Zähler f1: " + f1.getNumerator());
        System.out.println("Nenner f1: " + f1.getDenominator());
        System.out.println("f1 als double: " + f1.value());

        System.out.println(f1.toString());
        System.out.println(f2.toString());

        Fraction f3 = new Fraction(10,4);
        f1.addMut(f3);
        System.out.println(f1.toString());
        System.out.println("f1 als double: " + f1.value());

        Fraction f4 = new Fraction(1,4);
        f1.multMut(f4);
        System.out.println(f1.toString());
        System.out.println("f1 als double: " + f1.value());

        Fraction f5 = new Fraction(1,2);
        Fraction f6 = new Fraction(7,8);
        Fraction f7 = new Fraction(3,4);
        System.out.println(f1.compareTo(f5));
        System.out.println(f1.compareTo(f6));
        System.out.println(f1.compareTo(f7));

        Fraction f = new Fraction(500,1000);
        System.out.println(f.getNumerator() + "/" + f.getDenominator());
        f.shorten();
        System.out.println(f.getNumerator() + "/" + f.getDenominator());

        f = new Fraction(-4,-1024);
        System.out.println(f.getNumerator() + "/" + f.getDenominator());
        f.shorten();
        System.out.println(f.getNumerator() + "/" + f.getDenominator());

        f = new Fraction(25,-250);
        System.out.println(f.getNumerator() + "/" + f.getDenominator());
        f.shorten();
        System.out.println(f.getNumerator() + "/" + f.getDenominator());
        */
        Fraction a = new Fraction(1,2);
        Fraction b = new Fraction(1,4);
        System.out.println(a);
        System.out.println(b);
        Fraction.swap(a,b);
        System.out.println(a);
        System.out.println(b);
    }
}
