package reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

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
    DateRange createDateRange(final Component[] components) {
        try {
            final LocalDate firstDate = LocalDate.of(
                    Integer.parseInt(((JTextField) components[2]).getText()),
                    Integer.parseInt(((JTextField) components[1]).getText()),
                    Integer.parseInt(((JTextField) components[0]).getText()));
            final LocalDate lastDate = LocalDate.of(
                    Integer.parseInt(((JTextField) components[5]).getText()),
                    Integer.parseInt(((JTextField) components[4]).getText()),
                    Integer.parseInt(((JTextField) components[3]).getText()));
            return new DateRange(firstDate, lastDate);
        }
        catch (Exception e){
            ErrorWindow errorWindow=new ErrorWindow(e);

            return new DateRange(LocalDate.of(0,0,0),LocalDate.of(0,0,0));
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        DateRange dateRange = createDateRange(this.components);
        List<Integer> freeRooms = controller.listFreeRooms(dateRange);
        // TODO ListView öffnen mit der Liste der freien Räume
        String rooms[]=new String[freeRooms.size()] ;
        for(int i=0;i<freeRooms.size();i++){
            rooms[i]="Room:"+freeRooms.get(i);
        }
        RoomList roomList = new RoomList(0,rooms);
    }

}
