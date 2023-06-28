package reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Class to implement a Frame to display a list of occupied or free rooms */
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
        roomList.setLayout(new GridLayout(2,1));

        // scroll pane for list of reservations and three buttons
        JScrollPane reservationPane = new JScrollPane();
        JList reservationList = new JList();
        reservationPane.add(reservationList);

        JPanel menuButtons = new JPanel();
        menuButtons.setLayout(new FlowLayout());

        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomList.dispose();
            }
        });
        menuButtons.add(close);

        roomList.add(reservationPane);
        roomList.add(menuButtons);

        roomList.pack();
        roomList.setLocationRelativeTo(null);

        roomList.setVisible(true);
    }
}
