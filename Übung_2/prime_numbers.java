class PrimeNumbers {
    public static void main(String[] args) {
        // Primzahlen haben zwei natürliche Teiler. Einer davon ist die 1 und einer die Zahl selbst.
        String x;
        for (int number = 2; number <= 100; number++) {
            int counter = 0;
            for (int denominator = 2; denominator <= number; denominator++) {
                if (number % denominator == 0) {
                    counter += 1;
                }
            }
            if (counter == 1) {
                x = Integer.toString(number);
                System.out.print(x + "\n");
            }
        }
    }
}