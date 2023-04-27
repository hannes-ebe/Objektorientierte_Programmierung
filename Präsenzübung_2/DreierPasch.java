public class DreierPasch {
    public static void main(String[] args) {
        /*Wie hoch ist die Wahrscheinlichkeit mit 3 Würfeln einen Dreierpasch zu würfeln?
        Lösen Sie diese Aufgabe durch Zusammenzählen der Ergebnismöglichkeiten über for-Schleifen.
        Geben Sie das Ergebnis nutzerfreundlich aus.
        Ich gehe alle möglichen Kombinationen mit for Schleifen durch und zähle mit. Wenn ein Pasch
        erreicht wird, wird ein zweiter counter hochgezählt.
         */
        int total_counter = 0;
        int pasch_counter = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++)
                {
                    total_counter += 1;
                    if (i == j & j == k) {
                        pasch_counter += 1;
                    }
                }
            }
        }
        float probability = ((float) pasch_counter) / ((float) total_counter);
        System.out.println("pasch_counter: " + pasch_counter);
        System.out.println("total_counter: " + total_counter);
        System.out.println("Wahrscheinlichkeit eines Dreier-Pasches über for-Schleifen: " + probability);
    }
}
