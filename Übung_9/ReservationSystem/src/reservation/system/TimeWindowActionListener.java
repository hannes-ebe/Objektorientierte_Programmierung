package reservation.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

/** Class to open a time window. */
public class TimeWindowActionListener implements ActionListener {
    /** Index to  tell what kind of time window the listener is added to. */
    final int INDEX_OF_WINDOW;
    TimeWindowActionListener(int index) {
        INDEX_OF_WINDOW = index;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        TimeWindow timeWindow = new TimeWindow(INDEX_OF_WINDOW);
        // timeWindow.addActionListener()
    }
}
