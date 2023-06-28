package reservation.system;

import javax.swing.*;
import java.awt.*;

public class RoomList extends JFrame {
    JFrame roomList;
    RoomList(int index) {
        if (index == 0) {
            roomList = new JFrame("Free Rooms");
        } else {
            roomList = new JFrame(("Occupied Rooms"));
        }
        roomList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        roomList.setPreferredSize(new Dimension(500,120));
        roomList.setResizable(false);
    }
}
