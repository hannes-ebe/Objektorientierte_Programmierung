package reservation.system;

import javax.accessibility.AccessibleAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** ActionListener to open a RoomList window. */
public class RoomListActionListener implements ActionListener {
    final int ROOM_LIST_INDEX;
    RoomListActionListener(int index) {
        ROOM_LIST_INDEX = index;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        RoomList roomList = new RoomList(ROOM_LIST_INDEX);
    }
}
