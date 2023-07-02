package reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;



public class ReservationActionListener implements ActionListener {
        private final Reservations controller;
        private final Component[] components;
        private final int roomnumber;
        /**
         * Es wird das Reservations-Objekt übergeben, welches ursprünglich in ReservationSystem instanziiert wurde
         * und es werden die Formularfelder benötigt. Hier als Array übergeben. Das geht natürlich auf für jedes
         * Feld einzeln.
         */
        public ReservationActionListener(Reservations controller, Component[] components, int roomnumber) {
            this.controller = controller;
            this.components = components;
            this.roomnumber=roomnumber;
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
            try{
                controller.reserveRoom(roomnumber,dateRange);
                RoomOverview roomOverview=new RoomOverview(controller,roomnumber);
            }
            catch (Exception ex){
                ErrorWindow errorWindow=new ErrorWindow(ex);
            }

        }

    }


