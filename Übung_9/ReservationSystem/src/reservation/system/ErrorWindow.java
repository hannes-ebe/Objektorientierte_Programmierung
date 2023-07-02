package reservation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
public class ErrorWindow extends JFrame{
    public ErrorWindow(Exception e){
        JFrame errorWindow= new JFrame("An error has occurred");
        JLabel errorText=new JLabel(e.getMessage());

        JButton close=new JButton("close");
        errorWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        errorWindow.setPreferredSize(new Dimension(500, 120));
        errorWindow.setLayout(new GridLayout(2, 1));
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorWindow.dispose();
            }
        });
        errorWindow.add(errorText);
        errorWindow.add(close);
        errorWindow.pack();
        errorWindow.setLocationRelativeTo(null);
        errorWindow.setVisible(true);
    }
}
