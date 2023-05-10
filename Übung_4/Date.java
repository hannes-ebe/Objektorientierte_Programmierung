public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        // Der Konstruktor für die Daten. Falls ein Datum ungültig ist, wird Fehlermeldung zurückgegeben.
        if (validate(year,month,day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        else {
            System.out.println("ERROR: Illegal date.");
        }
    }

    private static boolean isLeapYear(int year) {
        boolean leap;
        if (year % 4 == 0 && year % 100 != 0) {
            leap = true;
        }
        else {
            if (year % 400 == 0) {
                leap = true;
            } else {
                leap = false;
            }
        }
        return leap;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public static int getDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        else {
            if (isLeapYear(year)) {
                return 29;
            }
            else {
                return 28;
            }
        }
    }

    public static boolean validate(int year, int month, int day) {
        // Überprüfe, ob das Datum gültig ist. Nur Jahre zwischen 1000 und 9999 gültig.
        if (1000 <= year && year <= 9999) {
            if (0 < month && month <= 12) {
                int daysInMonth = getDaysInMonth(year, month);
                if (0 < day && day <= daysInMonth) {
                    return true;
                } else {
                    return false;
                }
            }
            else {
                    return false;
                }
            }
        else {
            return false;
        }
    }

    public int dayOfYear() {
        // Gibt den Tag des Jahres der Date-Instanz zurück.
        int doy = 0;
        for (int i=1; i<this.month; i++) {
            // Für jeden vollen Monat werden schonmal 28 Tage addiert.
            doy += 28;
            if (i==1 || i==3 || i==5 || i==7 || i==8 || i==10) {
                // Tage mit 31 Tagen
                doy += 3;
            }
            if (i==4 || i==6 || i==9 || i==11) {
                // Tage mit 30 Tagen
                doy += 2;
            }
        }
        if (isLeapYear(year)) {
            // Berücksichtige Schaltjahre
            doy += 1;
        }
        // Addiere die Tage des aktuellen Monats.
        doy += this.day;
        return doy;
    }

    public int sameYearDiff(Date other) {
        // Um wie viele Tage sind die Daten verschoben, wenn sie im selben Jahr liegen? Wenn other in der Zukunft
        // liegt, ist die Rückgabe positiv, sonst negativ. Bei unterschiedlichen Jahren ist die Rückgabe Null.
        if (this.year == other.getYear()) {
            int doyThis = this.dayOfYear();
            int doyOther = other.dayOfYear();
            int diff = doyOther - doyThis;
            return diff;
        }
        else {
            return 0;
        }
    }

    public String toString() {
        int n = 12;
        String[] months = new String[n];
        months[0] = "January";
        months[1] = "February";
        months[2] = "March";
        months[3] = "April";
        months[4] = "May";
        months[5] = "June";
        months[6] = "July";
        months[7] = "August";
        months[8] = "September";
        months[9] = "October";
        months[10] = "November";
        months[11] = "December";

        String res = months[this.month-1] + " " + this.day + ", " + this.year;

        return res;
    }
}
