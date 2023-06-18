package controller;
import java.awt.*;

import javax.swing.*;

import model.World;
import view.ConsoleView;
import view.GraphicView;


/**
 * This is our main program. It is responsible for creating all of the objects
 * that are part of the MVC pattern and connecting them with each other.
 */
public class Labyrinth {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Dimension of the game board (10x10).
                int width = 10;
                int height = 10;
                // Create a new game world.
                World world = new World(width, height);

                // Size of a field in the graphical view.
                // field dimensions have been doubled to 50 instead of 25 to get a larger window
                Dimension fieldDimensions = new Dimension(50, 50);
                // Size of the buttons on the right of the GUI.
                Dimension buttonsDimensions = new Dimension((fieldDimensions.width * width)/2, fieldDimensions.height * height);
                // Dimensions of graphic view.
                Dimension graphicViewDimensions = new Dimension(width * fieldDimensions.width, height * fieldDimensions.height);


                // Create and register graphical view.
                GraphicView gview = new GraphicView(graphicViewDimensions.width, graphicViewDimensions.height, fieldDimensions);
                world.registerView(gview);
                gview.setVisible(true);

                // Create and register console view.
                ConsoleView cview = new ConsoleView();
                world.registerView(cview);

                // Create controller and initialize JFrame.
                Controller controller = new Controller(world);
                controller.setTitle("Labyrinth-Person");
                controller.setResizable(false);                
                controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                // Setting Layout to null.
                // Manual positioning of elements
                controller.setLayout(null);
                Insets insets = controller.getInsets();

                controller.add(gview);
                gview.setBounds(insets.left,insets.top,graphicViewDimensions.width,graphicViewDimensions.height);


                // Create a button for restart
                JButton restart = new JButton("Restart Game");
                controller.registerButton(restart);
                JButton difficulty = new JButton(("Change Difficulty"));
                // Create JPanel with new preferred size
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new GridLayout(0,1));
                // Add button to panel
                buttonPanel.add(restart);
                buttonPanel.add(difficulty);
                // Add panel to JFrame
                controller.add(buttonPanel);
                buttonPanel.setBounds(graphicViewDimensions.width, insets.top, buttonsDimensions.width, buttonsDimensions.height);


                // pack() is needed before JFrame size can be calculated.
                controller.pack();

                // Calculate size of window by size of insets (titlebar + border) and size of graphical view.
                insets = controller.getInsets();
                int windowX = graphicViewDimensions.width + insets.left + insets.right + buttonsDimensions.width;
                int windowY = graphicViewDimensions.height + insets.bottom + insets.top;
                Dimension size = new Dimension(windowX, windowY);
                controller.setSize(size);
                controller.setMinimumSize(size);
                controller.setVisible(true);

            }
        });
    }
}
