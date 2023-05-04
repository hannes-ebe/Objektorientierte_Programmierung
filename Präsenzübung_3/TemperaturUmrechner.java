public class TemperaturUmrechner {
    private static final double C_FAHRENHEIT_FAKTOR = 1.8;
    private static final double C_FAHRENHEIT_KONSTANTE = 32.0;
    // Nutze Default-Konstruktor; keine Variablen für Celsius und Fahrenheit, wäre ja umständlich
    // Die Klasse soll nur die benötigten Funktionen als statische Methoden bereitstellen.
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * C_FAHRENHEIT_FAKTOR + C_FAHRENHEIT_KONSTANTE;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - C_FAHRENHEIT_KONSTANTE) / C_FAHRENHEIT_FAKTOR;
    }
}
