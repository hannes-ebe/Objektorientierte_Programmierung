package reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Class to create a window for the room overview */
public class RoomOverview extends JFrame {
    RoomOverview() {
        JFrame roomOverview = new JFrame("Room Overview");
        roomOverview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        roomOverview.setPreferredSize(new Dimension(500,120));
        roomOverview.setResizable(false);
        roomOverview.setLayout(new GridLayout(2,1));

        // scroll pane for list of reservations and three buttons
        JScrollPane reservationPane = new JScrollPane();
        JList reservationList = new JList();
        reservationPane.add(reservationList);

        JPanel menuButtons = new JPanel();
        menuButtons.setLayout(new FlowLayout());

        JButton reserve = new JButton("Reserve");
        JButton delete = new JButton("Delete");
        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomOverview.dispose();
            }
        });
        menuButtons.add(reserve);
        menuButtons.add(delete);
        menuButtons.add(close);

        roomOverview.add(reservationPane);
        roomOverview.add(menuButtons);

        roomOverview.pack();
        roomOverview.setLocationRelativeTo(null);

        roomOverview.setVisible(true);
    }
}
