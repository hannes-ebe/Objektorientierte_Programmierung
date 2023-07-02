package reservation.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Action Listener to open the RoomOverview window. */
public class RoomOverviewActionListener implements ActionListener {
    /** Index of text field the listener is added to. */
    final int TEXT_FIELD_INDEX;
    Reservations reservations;
    RoomOverviewActionListener(int index,Reservations reservations1) {
        TEXT_FIELD_INDEX = index;
        reservations= reservations1;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Opens RoomOverview for specific room.
        RoomOverview roomOverview = new RoomOverview(reservations,TEXT_FIELD_INDEX);
    }
}
