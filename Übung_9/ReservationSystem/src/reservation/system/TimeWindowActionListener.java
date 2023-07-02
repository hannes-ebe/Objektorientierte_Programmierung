package reservation.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

/** Class to open a time window. */
public class TimeWindowActionListener implements ActionListener {
    /** Index to  tell what kind of time window the listener is added to. */
    final int INDEX_OF_WINDOW;
    private Reservations reservations;

    final int roomnumber;
    TimeWindowActionListener(Reservations reservations, int index, int roomnumber1) {
        INDEX_OF_WINDOW = index;
        this.reservations = reservations;
        this.roomnumber=roomnumber1;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        TimeWindow timeWindow = new TimeWindow(reservations,INDEX_OF_WINDOW,roomnumber);
    }
}
