public class TemperaturUmrechnerTest {
    public static void main(String[] args) {
        double val_c = 20.0;
        double val_f = TemperaturUmrechner.celsiusToFahrenheit(val_c);
        System.out.println(val_f);
    }
}
