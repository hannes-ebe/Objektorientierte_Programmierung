package reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;



public class DeleteActionListener implements ActionListener {
    private final Reservations controller;
    private final Component[] components;
    private final int roomnumber;
    /**
     * Es wird das Reservations-Objekt übergeben, welches ursprünglich in ReservationSystem instanziiert wurde
     * und es werden die Formularfelder benötigt. Hier als Array übergeben. Das geht natürlich auf für jedes
     * Feld einzeln.
     */
    public DeleteActionListener(Reservations controller, Component[] components, int roomnumber) {
        this.controller = controller;
        this.components = components;
        this.roomnumber=roomnumber;
    }
    /** creating a DateRange-Object from components */
    LocalDate createDate(final Component[] components) {
        final LocalDate firstDate = LocalDate.of(
                Integer.parseInt(((JTextField) components[2]).getText()),
                Integer.parseInt(((JTextField) components[1]).getText()),
                Integer.parseInt(((JTextField) components[0]).getText()));
        return firstDate;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDate date= createDate(this.components);
        try{
            controller.freeRoom(roomnumber,date);
            RoomOverview roomOverview=new RoomOverview(controller,roomnumber);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

}


