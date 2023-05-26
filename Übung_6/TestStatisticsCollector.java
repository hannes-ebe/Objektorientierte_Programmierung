public class TestStatisticsCollector {
    public static void main(String[] args) {
        /*
        StatisticsCollector stats = new StatisticsCollector();
        int n = 9;
        double[] list = new double[n];
        list[0] = 5.0;
        list[1] = 92.0;
        list[2] = 42.0;
        list[3] = 17.0;
        list[4] = 53.0;
        list[5] = 23.0;
        list[6] = 13.0;
        list[7] = 1.0;
        list[8] = 6.0;
        System.out.println("Without added numbers:");
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
        System.out.println(stats.getMinimum());
        System.out.println(stats.getMaximum());
        System.out.println(stats.getAverage());
        System.out.println(stats.getStandardDeviation());
        stats.addItems(list);
        System.out.println("With added numbers:");
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
        System.out.println(stats.getMinimum());
        System.out.println(stats.getMaximum());
        System.out.println(stats.getAverage());
        System.out.println(stats.getStandardDeviation());
        */
        double[] items2 = {5, 92, 42, 17, 53, 23, 13, -5, 6};
        StatisticsCollector sc2 = new StatisticsCollector();
        sc2.addItems(items2);
        System.out.printf("%.2f",sc2.getAverage());
    }
}
