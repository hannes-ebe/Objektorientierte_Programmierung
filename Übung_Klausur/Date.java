public class Date {

/** The month names , collected in a handy array . */
private static final String[] MONTH_NAMES = { " January ", " February ",
    " March ", " April ", "May", " June ", " July ",
    " August ", " September ", " October ", " November ", " December " };

    /** The date ’s year . Final because Date instances are immutable . */
    private final int year;
    /** The date ’s month . Final because Date instances are immutable . */
    private final int month;
    /** The date ’s day . Final because Date instances are immutable . */
    private final int day;

    /**
    * Creates a new date instance representing the given date .
    * The date is expected
    * to be valid as specified by { @link # validate (int , int , int )}.
    *
    * @param year the year .
    * @param month the month .
    * @param day the day.
    * @throws NullPointerException if the date is invalid .
    */
    public Date ( int year , int month , int day) {
        // Check if the date would be valid
        if (!validate(year,month,day)) {
        throw new IllegalArgumentException(" This is not a valid date !");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
    * Checks if the given date is valid .
    *
    * @param year the year .
    * @param month the month .
    * @param day the day.
    * @return { @code true } if the date is valid , { @code false } otherwise .
    */
    public static boolean validate ( int year , int month , int day) {
         return validateYear(year) && validateMonth(year,month)
            && validateDay(year,month,day);
    }

    @Override
    public String toString() {
        // Since this instance is a valid date , 1 <= month <= 12 holds .
        // Thus , the array access will always succeed .
        return MONTH_NAMES [ month - 1] + " " + day + ", " + year ;
    }

    private static boolean validateYear(int year) {
        // year has to have four digits.
        if (1000 <= year && year <= 9999) {
            return true;
        } else {
            return false;
        }
    }
    private static boolean validateMonth(int year, int month) {
        if (validateYear(year) && 1 <= month && month <= 12) {
            return true;
        } else {
            return false;
        }
    }
    private static int getMaximumDay(int month, int year) {
        int maxDay;

        // Determine the maximum number of days based on the month
        switch (month) {
            case 2: // February
                if (isLeapYear(year)) {
                    maxDay = 29;
                } else {
                    maxDay = 28;
                }
                break;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                maxDay = 30;
                break;
            default:
                maxDay = 31;
        }

        return maxDay;
    }

    private static boolean isLeapYear(int year) {
        // Check if the year is a leap year
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    private static boolean validateDay(int year, int month, int day) {
        if (validateYear(year) && validateMonth(year,month)) {
            // Check if the day is valid for the given month and year
            int maxDay = getMaximumDay(month, year);
            if (day < 1 || day > maxDay) {
                return false;
            }

            return true;
        } else {
            return false;
        }
    }

    public static void main(String[]args){
        // Date a = new Date (1970 , -1, 2); // IllegalArgumentException
        // Date b = new Date (1970 , 2, 31) ; // IllegalArgumentException
        System.out.println (new Date (1993 , 5, 4)); // May 4, 1993
    }
}