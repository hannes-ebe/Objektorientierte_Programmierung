public class TestDate {
    public static void main(String[] args) {
        Date dweihnachten = new Date(2022,12,24);
        Date other1 = new Date(2000,11,24);
        Date other2 = new Date(2022,11,24);
        System.out.println(dweihnachten.getYear());
        System.out.println(dweihnachten.getMonth());
        System.out.println(dweihnachten.getDay());
        System.out.println(Date.getDaysInMonth(2000,2));
        System.out.println(Date.validate(2023,9,13));
        System.out.println(Date.validate(84,34,1));
        System.out.println(dweihnachten.sameYearDiff(other1));
        System.out.println(dweihnachten.sameYearDiff(other2));
        System.out.println(dweihnachten);



        // testing sameYearDiff()
        Date d1 = new Date(2022,4,28);
        Date d2 = new Date(2022,12,24);
        System.out.println(d1.sameYearDiff(d2));
        Date d3 = new Date(2022,1,31);
        System.out.println(d1.sameYearDiff(d3));
        Date d4 = new Date(2022,6,22);
        System.out.println(d1.sameYearDiff(d4));
        Date d5 = new Date(2022,4,30);
        System.out.println(d1.sameYearDiff(d5));



        // testing dayOfYear()
        Date doy = new Date(2222,2,22);
        System.out.println(doy.dayOfYear());
        Date doy2 = new Date(2004,4,4);
        System.out.println(doy2.dayOfYear());
        Date doy3 = new Date(2006,6,6);
        System.out.println(doy3.dayOfYear());


    }
}
