package reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Class to implement a Frame to display a list of occupied or free rooms */
public class RoomList extends JFrame {
    JFrame roomList;
    RoomList(int index, String[] rooms) {
        if (index == 0) {
            roomList = new JFrame("Free Rooms");
        } else {
            roomList = new JFrame(("Occupied Rooms"));
        }
        roomList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        roomList.setPreferredSize(new Dimension(250, 250));
        roomList.setResizable(false);
        roomList.setLayout(new FlowLayout());

        // scroll pane for list of reservations and three buttons
        JPanel rList= new JPanel();

        JList reservationList = new JList(rooms);
        JScrollPane reservationPane = new JScrollPane(reservationList);
        //reservationPane.add(reservationList);
        rList.add(reservationPane);
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

        roomList.add(rList);
        roomList.add(menuButtons);

        roomList.pack();
        roomList.setLocationRelativeTo(null);

        roomList.setVisible(true);
    }
}
