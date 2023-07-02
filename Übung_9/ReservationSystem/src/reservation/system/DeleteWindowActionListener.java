package reservation.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteWindowActionListener implements ActionListener {
    final int index;
    Reservations controller;
    public DeleteWindowActionListener(Reservations reservations,int rn){
        this.index=rn;
        this.controller=reservations;
    }
    public void actionPerformed(ActionEvent e){
            DeleteWindow deleteWindow = new DeleteWindow(controller,index);
    }
}
