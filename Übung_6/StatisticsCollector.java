/**
 * A class to do statistics on a list of numbers.
 */
public class StatisticsCollector {
    /** The array containing the numbers of the class. */
    private double[] numbers;
    /** The length of the array (count of elements) provided by the class object. */
    private int count = 0;
    /** Sum of all elements */
    private int sum = 0;
    /** Minimum of all elements. */
    private double minimum = Double.POSITIVE_INFINITY;
    /** Maximum of all elements. */
    private double  maximum = Double.NEGATIVE_INFINITY;
    /** Average of all elements. */
    private double average = 0.0;
    /** Standard deviation of all elements. */
    private double standardDeviation = 0.0;
    /** Sum of squared residuals of all elements */
    private double squaredResiduals = 0.0;

    /**
     * Adds the items of {@code newNumbers} to the array provided by the class.
     * Furthermore, all necessary variables are being calculated.
     * @param newNumbers The array with the number to be added to the class object.
     */
    public void addItems(double[] newNumbers){
        count = newNumbers.length;
        numbers = new double[count];
        for (int i = 0; i < count; i++) {
            double number = newNumbers[i];
            numbers[i] = number;
            sum += number;
            minimum = Math.min(number,minimum);
            maximum = Math.max(number,maximum);
            }
        // Typecasting to get decimal values.
        average = (double) sum/count;
        // Bessel's correction is not being used.
        for (int i = 0; i < count; i++) {
            double number = newNumbers[i];
            squaredResiduals += Math.pow((number - average),2.0);
        }
        standardDeviation = Math.sqrt(squaredResiduals/count);
    }
    /**
     * Returns the number of added elements.
     * @return length of list provided by class object.
     */
    public int getCount() {
        return count;
    }
    /**
     * Returns the sum of all added elements.
     * @return sum of all added elements.
     */
    public double getSum() {
        return sum;
    }
    /**
     * Returns the minimum of all elements.
     * @return minimum of all elements.
     */
    public double getMinimum() {
        return minimum;
    }
    /**
     * Returns the maximum of all elements.
     * @return maximum of all elements.
     */
    public double getMaximum() {
        return maximum;
    }
    /**
     * Returns the average of all elements.
     * @return average of all elements.
     */
    public double getAverage() {
        return average;
    }
    /**
     * Returns the standard deviation of all elements.
     * @return standard deviation of all elements.
     */
    public double getStandardDeviation() {
        return standardDeviation;
    }
}
