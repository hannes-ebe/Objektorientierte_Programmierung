package model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import view.View;

import javax.swing.*;

/**
 * The world is our model. It saves the bare minimum of information required to
 * accurately reflect the state of the game. Note how this does not know
 * anything about graphics.
 */
public class World {

	public static final int DIR_RIGHT = 3;
	public static final int DIR_LEFT = 2;
	public static final int DIR_DOWN = 1;
	public static final int DIR_UP = 0;
	/** The world's width. */
	private final int width;
	/** The world's height. */
	private final int height;
	/** The start's x position. */
	private final int startX;
	/** The start's y position. */
	private final int startY;
	/** The destination's x position. */
	private final int destinationX;
	/** The destination's y position. */
	private final int destinationY;
	/** The player's x position in the world. */
	private int playerX = 0;
	/** The player's y position in the world. */
	private int playerY = 0;

	/** Set of views registered to be notified of world updates. */
	private final ArrayList<View> views = new ArrayList<>();

	/**
	 * Creates a new world with the given size.t
	 */
	public World(int width, int height) {
		// Normally, we would check the arguments for proper values
		this.width = width;
		this.height = height;
		this.startX = 0;
		this.startY = 0;
		this.destinationX = width - 1;
		this.destinationY = height - 1;
	}

	///////////////////////////////////////////////////////////////////////////
	// Getters and Setters

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public int getStartX() { return startX; }
	public int getStartY() { return startY; }
	public int getDestinationX() { return destinationX; }
	public int getDestinationY() { return destinationY; }

	public int getPlayerX() {
		return playerX;
	}

	public void setPlayerX(int playerX) {
		playerX = Math.max(0, playerX);
		playerX = Math.min(getWidth() - 1, playerX);
		this.playerX = playerX;
	}
	private boolean destinationReached() {
		if (playerX == destinationX && playerY == destinationY) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		playerY = Math.max(0, playerY);
		playerY = Math.min(getHeight() - 1, playerY);
		this.playerY = playerY;
	}


	///////////////////////////////////////////////////////////////////////////
	// Player Management
	
	/**
	 * Moves the player along the given direction.
	 * 
	 * @param direction where to move. 1 up, 2 down, 3, left, 4 right
	 */
	public void movePlayer(int direction) {	
		// The direction tells us exactly how much we need to move along
		// every direction
		setPlayerX(getPlayerX() + Direction.getDeltaX(direction));
		setPlayerY(getPlayerY() + Direction.getDeltaY(direction));
		updateViews();
	}

	///////////////////////////////////////////////////////////////////////////
	// View Management

	/**
	 * Adds the given view of the world and updates it once. Once registered through
	 * this method, the view will receive updates whenever the world changes.
	 * 
	 * @param view the view to be registered.
	 */
	public void registerView(View view) {
		views.add(view);
		view.update(this);
	}

	/**
	 * Updates all views by calling their {@link View#update(World)} methods.
	 * Checks whether the destination has been reached.
	 */
	public void updateViews() {
		for (int i = 0; i < views.size(); i++) {
			views.get(i).update(this);
		}
		if (destinationReached()) {
			// Output on console
			System.out.println("Congratulations. You have reached the destination and won the game.");
			System.out.println();
			// JDialog to ask for further steps
			JDialog destinationReached = new JDialog();
			destinationReached.setTitle("Congratulations! You won the game.");
			destinationReached.setSize(300,75);
			// JDialog cannot be closed on its own. The game can be restarted or the whole application
			// can be closed using the button.
			destinationReached.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

			// Create panel
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());

			// Create buttons
			JButton restart = new JButton(new AbstractAction("Restart Game") {
				@Override
				public void actionPerformed(ActionEvent e) {
					setPlayerX(startX);
					setPlayerY(startY);
					System.out.println("Game restarted.");
					updateViews();
					// Close JDialog
					destinationReached.dispose();
				}
			});
			JButton close = new JButton(new AbstractAction("Close Game") {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Application is terminated completely.
					System.exit(0);
				}
			});
			panel.add(restart);
			panel.add(close);

			destinationReached.add(panel);
			destinationReached.setModal(true);
			destinationReached.setVisible(true);
		}
	}
}
