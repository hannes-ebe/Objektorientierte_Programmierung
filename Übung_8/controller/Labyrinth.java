package controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

                controller.getContentPane().add(gview);
                gview.setBounds(insets.left,insets.top,graphicViewDimensions.width,graphicViewDimensions.height);

                // Creating a menu bar
                JMenuBar menuBar = new JMenuBar();

                JMenu menu = new JMenu("Options");
                menu.add(new JButton(new AbstractAction("Restart Game") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.restart();
                        world.updateViews();
                    }
                }));
                menu.add(new JButton(new AbstractAction("  Close Game ") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.closeApplication();
                    }
                }));

                JMenu menu2 = new JMenu("Difficulty");
                menu2.add(new JButton(new AbstractAction("Easy") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Hier die Einstellung der einfachen Schwierigkeit...
                    }
                }));
                menu2.add(new JButton(new AbstractAction("Hard") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Hier die Einstellung der schweren Schwierigkeit...
                    }
                }));

                menuBar.add(menu);
                menuBar.add(menu2);
                controller.setJMenuBar(menuBar);


                // pack() is needed before JFrame size can be calculated.
                controller.pack();

                // Calculate size of window by size of insets (titlebar + border) and size of graphical view.
                insets = controller.getInsets();
                int windowX = graphicViewDimensions.width + insets.left + insets.right;
                int windowY = graphicViewDimensions.height + insets.bottom + insets.top + menuBar.getHeight();
                Dimension size = new Dimension(windowX, windowY);
                controller.setSize(size);
                controller.setMinimumSize(size);
                controller.setVisible(true);

            }
        });
    }
}
