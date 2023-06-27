package controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

import model.World;
import view.ConsoleView;
import view.GraphicView;


/**
 * This is our main program. It is responsible for creating all the objects
 * that are part of the MVC pattern and connecting them with each other.
 */
public class Labyrinth {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Dimension of the game board.
                int width = 31;
                int height = 31;

                // Create labyrinth for game world.
                boolean[][] labyrinth = new boolean[width][height];
                boolean[] helpArray0 = {false,false,false,false,false,false,true,false,false,false,false,false,false,
                        false,false,true,false,false,false,true,false,false,false,true,false,false,false,true,false,false,false};
                labyrinth[0] = helpArray0;
                boolean[] helpArray1 = {false,true,false,true,true,false,true,false,true,true,true,true,true,
                        true,false,true,true,true,false,true,true,true,false,true,false,true,true,true,false,true,false};
                labyrinth[1] = helpArray1;
                boolean[] helpArray2 = {false,false,false,false,false,false,false,false,true,false,false,false,false,
                        false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
                labyrinth[2] = helpArray2;
                boolean[] helpArray3 = {false,true,true,false,true,true,true,false,true,true,false,true,true,
                        true,true,true,true,true,true,true,false,true,true,false,true,true,false,true,true,true,false};
                labyrinth[3] = helpArray3;
                boolean[] helpArray4 = {false,false,false,false,false,true,false,false,false,false,false,false,false,
                        false,false,true,false,false,false,false,false,false,false,false,true,false,false,false,true,false,false};
                labyrinth[4] = helpArray4;
                boolean[] helpArray5 = {true,true,true,true,false,true,true,true,true,true,true,true,true,
                        false,true,true,true,true,false,true,true,true,false,true,true,false,true,true,true,false,true};
                labyrinth[5] = helpArray5;
                boolean[] helpArray6 = {false,false,false,false,false,true,false,false,false,false,false,false,false,
                        false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
                labyrinth[6] = helpArray6;
                boolean[] helpArray7 = {false,true,true,true,true,true,true,false,true,true,true,false,true,
                        true,false,true,true,true,true,true,true,false,true,true,false,true,true,true,true,true,false};
                labyrinth[7] = helpArray7;
                boolean[] helpArray8 = {false,false,false,false,true,false,false,false,true,false,false,false,false,
                        false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false};
                labyrinth[8] = helpArray8;
                boolean[] helpArray9 = {true,true,true,false,true,false,true,true,true,true,true,true,true,
                        true,true,true,true,false,true,false,true,true,true,true,true,false,true,true,true,true,true};
                labyrinth[9] = helpArray9;
                boolean[] helpArray10 = {false,false,false,false,false,false,false,false,false,false,false,false,false,
                        false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
                labyrinth[10] = helpArray10;
                boolean[] helpArray11 = {false,true,true,true,true,false,true,false,true,false,true,true,true,
                        false,true,true,false,true,true,true,true,false,true,true,true,true,true,true,true,true,false};
                labyrinth[11] = helpArray11;
                boolean[] helpArray12 = {false,true,false,false,false,false,false,false,true,false,false,false,false,
                        false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false};
                labyrinth[12] = helpArray12;
                boolean[] helpArray13 = {false,true,false,true,true,true,true,true,true,false,true,true,true,
                        true,true,false,true,true,true,true,false,true,true,true,true,true,false,true,true,true,false};
                labyrinth[13] = helpArray13;
                boolean[] helpArray14 = {false,false,false,false,false,false,false,false,false,false,false,false,false,
                        true,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false};
                labyrinth[14] = helpArray14;
                boolean[] helpArray15 = {false,true,true,true,false,true,true,true,false,true,true,true,false,
                        false,false,false,false,false,false,true,true,true,false,true,true,false,true,true,true,true,false};
                labyrinth[15] = helpArray15;
                boolean[] helpArray16 = {false,false,false,false,false,false,false,false,false,false,false,false,false,
                        true,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false};
                labyrinth[16] = helpArray16;
                boolean[] helpArray17 = {true,true,true,true,true,false,true,true,true,false,true,true,true,
                        true,true,false,true,true,true,true,true,false,true,true,true,true,true,false,true,true,true};
                labyrinth[17] = helpArray17;
                boolean[] helpArray18 = {false,true,false,false,true,false,false,false,false,false,true,false,false,
                        false,false,false,true,false,false,false,false,false,false,true,false,false,false,false,false,false,false};
                labyrinth[18] = helpArray18;
                boolean[] helpArray19 = {false,true,true,false,true,false,true,true,false,true,true,true,true,
                        false,true,true,true,true,false,true,true,false,true,true,true,true,false,true,true,true,false};
                labyrinth[19] = helpArray19;
                boolean[] helpArray20 = {false,false,false,false,false,false,false,true,false,false,false,true,false,
                        false,false,false,false,true,false,false,false,false,false,false,true,false,false,false,false,false,false};
                labyrinth[20] = helpArray20;
                boolean[] helpArray21 = {true,true,false,true,true,true,false,true,true,true,true,true,false,
                        true,true,true,false,true,true,false,true,true,true,false,true,true,true,false,true,true,true};
                labyrinth[21] = helpArray21;
                boolean[] helpArray22 = {false,false,false,false,false,false,false,true,false,false,false,false,false,
                        true,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false};
                labyrinth[22] = helpArray22;
                boolean[] helpArray23 = {false,true,true,true,true,false,true,true,false,true,true,true,false,
                        true,true,true,true,false,true,true,false,true,true,true,true,false,true,true,true,true,false};
                labyrinth[23] = helpArray23;
                boolean[] helpArray24 = {false,false,false,false,false,false,false,true,false,false,false,false,false,
                        false,true,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false};
                labyrinth[24] = helpArray24;
                boolean[] helpArray25 = {true,true,true,false,true,true,false,true,true,true,true,true,false,
                        true,true,true,false,true,true,false,true,true,true,true,false,true,true,false,true,true,true};
                labyrinth[25] = helpArray25;
                boolean[] helpArray26 = {false,false,false,false,false,false,false,false,false,false,true,false,false,
                        false,false,false,false,false,true,false,false,false,false,true,false,true,false,false,false,false,false};
                labyrinth[26] = helpArray26;
                boolean[] helpArray27 = {false,true,true,true,true,false,true,true,true,false,true,true,true,
                        true,true,true,false,true,true,false,true,true,false,true,false,true,false,true,true,true,false};
                labyrinth[27] = helpArray27;
                boolean[] helpArray28 = {false,false,false,false,false,false,false,false,false,false,false,false,false,
                        false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
                labyrinth[28] = helpArray28;
                boolean[] helpArray29 = {false,true,false,true,true,true,true,false,true,true,true,false,true,
                        true,true,false,true,true,true,true,true,false,true,true,false,true,true,true,false,true,false};
                labyrinth[29] = helpArray29;
                boolean[] helpArray30 = {false,false,false,true,false,false,false,false,false,true,false,false,false,
                        false,false,false,true,false,false,false,false,false,false,false,false,false,true,false,false,false,false};
                labyrinth[30] = helpArray30;


                // Create a new game world.
                World world = new World(width, height, labyrinth);

                // Size of a field in the graphical view.
                Dimension fieldDimensions = new Dimension(25, 25);
                // Dimensions of graphic view.
                Dimension graphicViewDimensions = new Dimension(width * fieldDimensions.width, height * fieldDimensions.height);


                // Create and register graphical view./*
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

                JMenu menu2 = new JMenu("Set Difficulty");

                // Display current difficulty
                String currentDifficulty = world.getDifficultyString();
                JLabel difficultyTextField = new JLabel("    Current Difficulty:    " + currentDifficulty);

                menu2.add(new JButton(new AbstractAction("Easy") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        world.setDifficulty(0);
                        difficultyTextField.setText("    Current Difficulty:    " + world.getDifficultyString());
                    }
                }));
                menu2.add(new JButton(new AbstractAction("Medium") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        world.setDifficulty(1);
                        difficultyTextField.setText("    Current Difficulty:    " + world.getDifficultyString());
                    }
                }));
                menu2.add(new JButton(new AbstractAction("Hard") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        world.setDifficulty(2);
                        difficultyTextField.setText("    Current Difficulty:    " + world.getDifficultyString());
                    }
                }));

                // Add menus first and then display the current difficulty.
                menuBar.add(menu);
                menuBar.add(menu2);
                menuBar.add(difficultyTextField);

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
