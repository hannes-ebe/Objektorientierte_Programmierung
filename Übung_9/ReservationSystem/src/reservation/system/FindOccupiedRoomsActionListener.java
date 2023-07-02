package reservation.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
public class FindOccupiedRoomsActionListener implements ActionListener {
     Reservations controller;
     Component[] components;
    public FindOccupiedRoomsActionListener(Reservations controller, Component[] components){
        this.controller= controller;
        this.components=components;
    }

    DateRange createDateRange(final Component[] components) {
        final LocalDate firstDate = LocalDate.of(
                Integer.parseInt(((JTextField) components[2]).getText()),
                Integer.parseInt(((JTextField) components[1]).getText()),
                Integer.parseInt(((JTextField) components[0]).getText()));
        final LocalDate lastDate = LocalDate.of(
                Integer.parseInt(((JTextField) components[5]).getText()),
                Integer.parseInt(((JTextField) components[4]).getText()),
                Integer.parseInt(((JTextField) components[3]).getText()));
        return new DateRange(firstDate, lastDate);
    }

    public void actionPerformed(ActionEvent e) {
        DateRange dateRange = createDateRange(this.components);
        List<Integer> occupiedRooms = controller.listOccupiedRooms(dateRange);

        String rooms[]=new String[occupiedRooms.size()] ;
        for(int i=0;i<occupiedRooms.size();i++){
            rooms[i]="Room:"+occupiedRooms.get(i);
        }
        RoomList roomList = new RoomList(0,rooms);
    }
}
