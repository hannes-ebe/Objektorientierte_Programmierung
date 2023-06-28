package reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** Class to create a window to enter a date range */
public class TimeWindow extends JFrame {
    /** Constructor
     * @param index index to distinguish between free rooms (0), occupied rooms (1) or reserving a room (2)
     */
    TimeWindow(int index) {
        JFrame timeWindow = new JFrame("Enter Time Period");
        timeWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        timeWindow.setPreferredSize(new Dimension(500, 120));
        timeWindow.setResizable(false);
        timeWindow.setLayout(new GridLayout(4, 4));

        // first three indices are the start date
        // last three indices are the end date
        Component[] components = new Component[6];
        components[0] = new JTextField();
        components[1] = new JTextField();
        components[2] = new JTextField();
        components[3] = new JTextField();
        components[4] = new JTextField();
        components[5] = new JTextField();

        timeWindow.add(new JLabel());
        timeWindow.add(new JLabel("Day"));
        timeWindow.add(new JLabel("Month"));
        timeWindow.add(new JLabel("Year"));
        timeWindow.add(new JLabel("Start date:"));
        timeWindow.add(components[0]);
        timeWindow.add(components[1]);
        timeWindow.add(components[2]);
        timeWindow.add(new JLabel("End date:"));
        timeWindow.add(components[3]);
        timeWindow.add(components[4]);
        timeWindow.add(components[5]);
        timeWindow.add(new JLabel());
        timeWindow.add(new JLabel());

        if (index == 0) {
            JButton button = new JButton("View");
            button.addActionListener(new RoomListActionListener(index));
            timeWindow.add(button);
        } else if (index == 1) {
            JButton button = new JButton("View");
            button.addActionListener(new RoomListActionListener(index));
            timeWindow.add(button);
        } else {
            JButton button = new JButton("Reserve");
            timeWindow.add(button);
        }

        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeWindow.dispose();
            }
        });
        timeWindow.add(close);

        timeWindow.pack();
        timeWindow.setLocationRelativeTo(null);

        timeWindow.setVisible(true);
    }
}
