package reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteWindow extends JFrame {
    DeleteWindow(Reservations reservations,int rn){
        JFrame timeWindow = new JFrame("Enter Time Period");
        timeWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        timeWindow.setPreferredSize(new Dimension(500, 120));
        timeWindow.setResizable(false);
        timeWindow.setLayout(new GridLayout(3, 4));
        // first three indices are the start date
        // last three indices are the end date
        Component[] components = new Component[6];
        components[0] = new JTextField();
        components[1] = new JTextField();
        components[2] = new JTextField();

        timeWindow.add(new JLabel());
        timeWindow.add(new JLabel("Day"));
        timeWindow.add(new JLabel("Month"));
        timeWindow.add(new JLabel("Year"));
        timeWindow.add(new JLabel("Date:"));
        timeWindow.add(components[0]);
        timeWindow.add(components[1]);
        timeWindow.add(components[2]);
        timeWindow.add(new JLabel());
        timeWindow.add(new JLabel());
        JButton button = new JButton("Delete");
        button.addActionListener(new DeleteActionListener(reservations,components,rn));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeWindow.dispose();
            }
        });
        timeWindow.add(button);

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
