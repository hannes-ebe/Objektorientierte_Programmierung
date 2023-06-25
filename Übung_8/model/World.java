package model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.Labyrinth;
import view.View;

import javax.lang.model.type.NullType;
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

		private boolean inBounds(int k){
			return (k>=0 &&k<getWidth());
		}

		/**
		 * Difficulty with minmax Algorithm
		 */
		private ArrayList<Integer> possibleMoves(int x1,int y1){
			ArrayList<Integer> sol= new ArrayList();
			boolean pos=false;
			if(inBounds(x1+1)&&!labyrinth[x1+1][y1]) {//right
				sol.add(3);
				pos=true;
			}
			if(inBounds(x1-1)&&!labyrinth[x1-1][y1]){//left
				sol.add(2);
				pos=true;
			}
			if (inBounds(y1+1)&&!labyrinth[x1][y1+1]) {//up
				sol.add(0);
				pos=true;
			}
			if (inBounds(y1-1)&&!labyrinth[x1][y1-1]) {//down
				sol.add(1);
				pos=true;
			}

			if(!pos){ // Should not be possible,only if stuck between 4 walls.
				sol.add(-1);
			}
			return sol;
		}
		private void moveOpp(int dir){
			if(dir==DIR_UP){
				setY(getY()+1);
			}
			if(dir==DIR_DOWN){
				setY(getY()-1);
			}
			if(dir==DIR_LEFT){
				setX(getX()-1);
			}
			if(dir==DIR_RIGHT){
				setX(getX()+1);
			}
		}
		private void movePlayer(int dir){
			if(dir==DIR_UP){
				setPlayerY((getPlayerY()+1));
			}
			if(dir==DIR_DOWN){
				setPlayerY(getPlayerY()-1);
			}
			if(dir==DIR_LEFT){
				setPlayerX(getPlayerX()-1);
			}
			if(dir==DIR_RIGHT){
				setPlayerX(getPlayerX()+1);
			}
		}
		private int invertMove(int dir){
			if(dir==DIR_UP){
				return DIR_DOWN;
			}
			if(dir==DIR_DOWN){
				return DIR_UP;
			}
			if(dir==DIR_LEFT){
				return DIR_RIGHT;
			}
			if(dir==DIR_RIGHT){
				return DIR_LEFT;
			}
			return -1;
		}
		private double eval(int newX,int newY){
			return -(Math.abs(newX-getPlayerX())+Math.abs(newY-getPlayerY()));
		}

		private int wishdepth;
		private int saveturn;
		private double max(int tiefe) {

			if (tiefe == 0 || caught()) {
				return eval(getX(), getY());
			}
			double max = Float.NEGATIVE_INFINITY;
			ArrayList<Integer> moves = possibleMoves(getX(),getY());
			int move;
			double wert;
			while (!moves.isEmpty()) {
				move= moves.remove(0);// Do Move here and take it out of the List(save the move in a variable)
				moveOpp(move);
				wert = min(tiefe - 1);
				moveOpp(invertMove(move));
				if (wert > max) {
					max = wert;
					if (tiefe == wishdepth) {
						saveturn = move;
					}
				}
			}

			return max;
		}
	    private double min(int tiefe){
			if (tiefe==0 || caught()){
				return eval(x,y);
			}
			double min=Float.POSITIVE_INFINITY;
			ArrayList<Integer> moves=possibleMoves(getPlayerX(),getPlayerY());
			int move;
			double wert;
			while(!moves.isEmpty()){
				move=moves.remove(0);
				//movePlayer(move);
				wert=max(tiefe-1);
				//movePlayer(invertMove(move));
				if (wert < min) {
					min=wert;
					if(tiefe==wishdepth){
						saveturn=move;
					}
				}

			}
			return min;
		}



		/**
		 * Takes two random numbers (-1 or 1) to update the position of a pursuer.
		 */
		public void updatePursuer() {
			// first number tells whether the movement is in x- or y-direction, the
			// second whether it is in positive or negative direction.
			boolean validMove = false;
			if(getDifficulty()!=2) {
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
			if(getDifficulty()==2) {
				wishdepth=10;
				saveturn= -1;
				double wert =max(wishdepth);
				System.out.println(wert);
				if (saveturn!=-1) {
					moveOpp(saveturn);
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
