package reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class FindFreeRoomsActionListener implements ActionListener {
    private final Reservations controller;
    private final Component[] components;

    /**
     * Es wird das Reservations-Objekt übergeben, welches ursprünglich in ReservationSystem instanziiert wurde
     * und es werden die Formularfelder benötigt. Hier als Array übergeben. Das geht natürlich auf für jedes
     * Feld einzeln.
     */
    public FindFreeRoomsActionListener(Reservations controller, Component[] components) {
        this.controller = controller;
        this.components = components;
    }
    /** creating a DateRange-Object from components */
    private DateRange createDateRange(final Component[] components) {
        final LocalDate firstDate = LocalDate.of(
                Integer.parseInt(((JTextField) components[7]).getText()),
                Integer.parseInt(((JTextField) components[6]).getText()),
                Integer.parseInt(((JTextField) components[5]).getText()));
        final LocalDate lastDate = LocalDate.of(
                Integer.parseInt(((JTextField) components[11]).getText()),
                Integer.parseInt(((JTextField) components[10]).getText()),
                Integer.parseInt(((JTextField) components[9]).getText()));
        return new DateRange(firstDate, lastDate);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        DateRange dateRange = createDateRange(this.components);
        //List<Integer> freeRooms = controller.listFreeRooms(dateRange);
        // TODO ListView öffnen mit der Liste der freien Räume
    }

}
