package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import model.Direction;
import model.World;
import view.View;

/**
 * Our controller listens for key events on the main window.
 */
public class Controller extends JFrame implements KeyListener, ActionListener, MouseListener {

	/** The world that is updated upon every key press. */
	private World world;
	private List<View> views;
	/** Set of buttons registered for the GUI. */
	private final ArrayList<JButton> buttons = new ArrayList<>();

	/**
	 * Creates a new instance.
	 * 
	 * @param world the world to be updated whenever the player should move.
	 * @param caged the {@link GraphicsProgram} we want to listen for key presses
	 *              on.
	 */
	public Controller(World world) {
		// Remember the world
		this.world = world;
		
		// Listen for key events
		addKeyListener(this);

		// Listen for mouse events.
		// Not used in the current implementation.
		addMouseListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/////////////////// Key Events ////////////////////////////////

	@Override
	public void keyPressed(KeyEvent e) {
		// Check if we need to do something. Tells the world to move the player.
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			world.movePlayer(1); // 1 to move up
			break;

		case KeyEvent.VK_DOWN:
			world.movePlayer(2); // 2 t move down
			break;

		case KeyEvent.VK_LEFT:
			world.movePlayer(3); // 3 to move left
			break;

		case KeyEvent.VK_RIGHT:
			world.movePlayer(4); // 4 to move right
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/////////////////// Action Events ////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		world.setPlayerX(world.getStartX());
		world.setPlayerY(world.getStartY());
		System.out.println("Game restarted.");
		System.out.println();*/
	}

	
	/////////////////// Mouse Events ////////////////////////////////

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	///////////////////////////////////////////////////////////////////////////
	// Button Management for GUI

	public void registerButton(JButton button) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				world.setPlayerX(world.getStartX());
				world.setPlayerY(world.getStartY());
				System.out.println("Game restarted.");
				System.out.println();
			}
		});
		buttons.add(button);
	}

	/**
	 * Get JButton corresponding to the index.
	 * @param i index of the JButton.
	 */
	public JButton getJButton(int i) {
		return buttons.get(i);
	}
}
