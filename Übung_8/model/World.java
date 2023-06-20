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
	/** The difficulty of the game.
	 *  Standard is 0 (easy). Other options are 1 (medium) or 2 (hard).
	 */
	private int difficulty = 0;
	/** Class to implement a pursuer. */
	public class Pursuer {
		/**
		 * x-coordinate
		 */
		private int x;
		/**
		 * y-coordinate
		 */
		private int y;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		/**
		 * Returns a random number -1 or 1.
		 */
		private int randomNumber() {
			if (Math.random() < 0.5) {
				return -1;
			} else {
				return 1;
			}
		}

		/**
		 * Takes two random numbers (-1 or 1) to update the position of a pursuer.
		 */
		public void updatePursuer() {
			// first number tells whether the movement is in x- or y-direction, the
			// second whether it is in positive or negative direction.
			boolean validMove = false;
			while (!validMove) {
				int xOrY = randomNumber();
				if (xOrY == -1) {
					int newX = this.x + randomNumber();
					// First check whether new position is on the game board.
					// Second check whether the pursuer hit a wall.
					if (newX >= 0 && newX < getWidth()) {
						if (!labyrinth[newX][getY()]) {
							this.x = newX;
							validMove = true;
						}
					}
				} else if (xOrY == 1) {
					int newY = this.y + randomNumber();
					// First check whether new position is on the game board.
					// Second check whether the pursuer hit a wall.
					if (newY >= 0 && newY < getWidth()) {
						if (!labyrinth[getX()][newY]) {
							this.y = newY;
							validMove = true;
						}
					}
				}
			}
		}
	}
	/** ArrayList to store the pursuers */
	private  final ArrayList<Pursuer> pursuers = new ArrayList<>();

	/** Set of views registered to be notified of world updates. */
	private final ArrayList<View> views = new ArrayList<>();
	/** 2-dimensional ArrayList to store labyrinth walls as true, else false.
	 * First dimension is x.
	 */
	private boolean[][] labyrinth;

	/**
	 * Creates a new world with the given size.t
	 */
	public World(int width, int height, boolean[][] labyrinth) {
		// Normally, we would check the arguments for proper values
		this.width = width;
		this.height = height;
		this.startX = 0;
		this.startY = 0;
		this.destinationX = width - 1;
		this.destinationY = height - 1;
		// Standard difficulty is set to 0 (easy).
		this.difficulty = 0;
		// There are always three pursuers.
		for (int i = 0; i < 3; i++) {
			pursuers.add(new Pursuer());
		}
		// Pursuers start at different positions of the field.
		setPursuersToStart();
		this.labyrinth = labyrinth;
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
		// Checks whether the new position is outside the game board.
		playerX = Math.max(0, playerX);
		playerX = Math.min(getWidth() - 1, playerX);
		this.playerX = playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		// Checks whether the new position is outside the game board.
		playerY = Math.max(0, playerY);
		playerY = Math.min(getHeight() - 1, playerY);
		this.playerY = playerY;
	}
	public int getDifficulty() { return difficulty; }
	public void setDifficulty(int difficulty) {this.difficulty = difficulty;}
	/** Get pursuer from ArrayList for specific index. */
	public Pursuer getPursuer(int index) {
		return pursuers.get(index);
	}
	public boolean[][] getLabyrinth() {
		return labyrinth;
	}

	///////////////////////////////////////////////////////////////////////////
	// Functions to check for certain player positions

	/** Checks whether the player has reached the destination */
	private boolean destinationReached() {
		if (playerX == destinationX && playerY == destinationY) {
			return true;
		}
		else {
			return false;
		}
	}
	/** Checks whether a pursuer has caught the player. */
	private boolean caught() {
		for (Pursuer pursuer: pursuers) {
			if (pursuer.getX() == playerX && pursuer.getY() == playerY) {
				return true;
			}
		}
		return false;
	}


	///////////////////////////////////////////////////////////////////////////
	// Player Management
	
	/**
	 * Moves the player along the given direction.
	 * 
	 * @param direction where to move. 1 up, 2 down, 3, left, 4 right
	 * @return boolean value whether the player has hit a wall. If he hit
	 * a wall nothing changes.
	 */
	public void movePlayer(int direction) {
		// The direction tells us exactly how much we need to move along
		// every direction
		int newX = getPlayerX() + Direction.getDeltaX(direction);
		int newY = getPlayerY() + Direction.getDeltaY(direction);
		// First check whether new position is on the game board.
		// Second check whether the player hit a wall.
		if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
			if (!(labyrinth[newX][newY])) {
				setPlayerX(newX);
				setPlayerY(newY);
			}
		}
	}


	///////////////////////////////////////////////////////////////////////////
	// Pursuer Management
	/** Sets the pursuers to their start positions. */
	public void setPursuersToStart() {
		pursuers.get(0).setX(startX);
		pursuers.get(0).setY(destinationY);
		pursuers.get(1).setX(destinationX);
		pursuers.get(1).setY(startY);
		pursuers.get(2).setX(destinationX / 2);
		pursuers.get(2).setY(destinationY / 2);
	}

	/** Updates positions of pursuers. */
	public void updatePursuers() {
		for (Pursuer pursuer: pursuers) {
			pursuer.updatePursuer();
		}
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

		// Ending current run of the game if the destination is reached.
		if (destinationReached()) {
			// Output on console
			System.out.println("Congratulations. You have reached the destination and won the game.");
			System.out.println();

			// JDialog to ask for further steps
			JDialog destinationReached = new JDialog();
			destinationReached.setTitle("Congratulations! You have won the game.");
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
					setPursuersToStart();
					System.out.println("Game restarted:");
					System.out.println();
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

		// Ending current run of the game if player is caught.
		if (caught()) {
			// Output on console
			System.out.println("Oh no! You have been caught.");
			System.out.println();

			// JDialog to ask for further steps
			JDialog caught = new JDialog();
			caught.setTitle("Oh no! You have been caught.");
			caught.setSize(300,75);
			// JDialog cannot be closed on its own. The game can be restarted or the whole application
			// can be closed using the button.
			caught.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

			// Create panel
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());

			// Create buttons
			JButton restart = new JButton(new AbstractAction("Restart Game") {
				@Override
				public void actionPerformed(ActionEvent e) {
					setPlayerX(startX);
					setPlayerY(startY);
					setPursuersToStart();
					System.out.println("Game restarted:");
					System.out.println();
					updateViews();
					// Close JDialog
					caught.dispose();
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

			caught.add(panel);
			caught.setModal(true);
			caught.setVisible(true);
		}
	}
}
