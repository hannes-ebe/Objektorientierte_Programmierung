public class Rennen {
    // Was ist eigentlich, wenn zufällig beide Schnecken bei selber Iteration die Gesamtstrecke zurücklegen???
    private String name;
    private int numParticipants;
    private int maxNumParticipants;
    private Rennschnecke[] participants;
    private double raceDistance;
    public Rennen(String name, int maxNumParticipants, double raceDistance) {
        this.name = name;
        this.maxNumParticipants = maxNumParticipants;
        this.raceDistance = raceDistance;
        this.participants = new Rennschnecke[maxNumParticipants];
    }
    public void addRennschnecke(Rennschnecke neueSchnecke) {
        participants[numParticipants] = neueSchnecke;
        numParticipants += 1;
    }
    public void removeRennschnecke(String name) {
        // wird erstmal übersprungen, da anscheinend nicht so leicht.
        // Bestimme Listen-Index, der zu name passt.
        if (numParticipants == maxNumParticipants){
            numParticipants -= 1;
        }
        else {
            int ind = 0;
            while (participants[ind].getName() != name) {
                ind += 1;
            }
            // Es wird vom zu löschenden Index aus die Referenz der jeweiligen Schnecke mit ihrem Nachfolger überschrieben.
            participants[ind] = participants[ind + 1];
            // Setze Zahl der Teilnehmer runter
            numParticipants -= 1;
        }
    }
    public Rennschnecke ermittleGewinner() {
        for (int i = 0; i<maxNumParticipants; i++) {
            if (raceDistance <= participants[i].getCoveredDistance()) {
                return participants[i];
            }
        }
        return null;
    }
    public void lasseSchneckenKriechen() {
        for (int i = 0; i<maxNumParticipants; i++) {
            participants[i].krieche();
            }
    }
    public void durchführen() {
        do {
            lasseSchneckenKriechen();
        } while (ermittleGewinner() == null);
    }
}
