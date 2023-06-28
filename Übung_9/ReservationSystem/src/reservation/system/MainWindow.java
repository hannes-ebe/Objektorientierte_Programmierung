package reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Class to create a main window. */
public class MainWindow extends JFrame {
    private JFrame mainWindow;
    private static final int NUMBER_OF_ROOMS = 10;
    /* rows and columns in which wooms are ordered in main window */
    private static final int ROOM_COLUMNS = 5;
    private static final int ROOM_ROWS = 2;
    MainWindow() {
        mainWindow = new JFrame("Reservation System");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setPreferredSize(new Dimension(500,120));
        mainWindow.setResizable(false);
        mainWindow.setLayout(new GridLayout(2,1));

        // buttons for different actions
        JPanel menuButtons = new JPanel();
        menuButtons.setLayout(new FlowLayout());

        JButton listFree = new JButton("List Free");
        listFree.addActionListener(new TimeWindowActionListener(0));
        JButton listOccupied = new JButton("List Occupied");
        listOccupied.addActionListener(new TimeWindowActionListener(1));
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuButtons.add(listFree);
        menuButtons.add(listOccupied);
        menuButtons.add(exit);

        // buttons for different rooms
        JPanel roomButtons = new JPanel();
        roomButtons.setLayout(new GridLayout(ROOM_ROWS,ROOM_COLUMNS));
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            JButton newRoom = new JButton("Room " + i);
            newRoom.addActionListener(new RoomOverviewActionListener(i));
            roomButtons.add(newRoom);
        }

        mainWindow.add(menuButtons);
        mainWindow.add(roomButtons);

        mainWindow.pack();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
}
