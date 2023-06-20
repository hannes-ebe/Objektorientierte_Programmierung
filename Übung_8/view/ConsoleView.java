package view;

import model.World;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A view that prints the current state of the world to the console upon every
 * update.
 */
public class ConsoleView implements View {

	@Override
	public void update(World world) {
		// The player's position
		int playerX = world.getPlayerX();
		int playerY = world.getPlayerY();
		// start and destination
		int startX = world.getStartX();
		int startY = world.getStartY();
		int destinationX = world.getDestinationX();
		int destinationY = world.getDestinationY();
		// pursuer's position
		// x-coordinates of pursuers
		int[] xPursuers = new int[3];
		// y-coordinates of pursuers
		int[] yPursuers = new int[3];
		for (int i = 0; i < 3; i++) {
			xPursuers[i] = world.getPursuer(i).getX();
			yPursuers[i] = world.getPursuer(i).getY();
		}
		// labyrinth of current game.
		boolean[][] labyrinth = world.getLabyrinth();

		for (int row = 0; row < world.getHeight(); row++) {
			for (int col = 0; col < world.getWidth(); col++) {
				// If the player is here, print #, otherwise print .
				// Start and destination are marked as S and D
				if (row == playerY && col == playerX) {
					System.out.print("#");
				} else if ((row == xPursuers[0] && col == yPursuers[0]) || (row == xPursuers[1] && col == yPursuers[1]) || (row == xPursuers[2] && col == yPursuers[2])) {
					System.out.print("X");
				} else if (row == startY && col == startX) {
					System.out.print('S');
				} else if (row == destinationY && col == destinationX) {
					System.out.print('D');
				} else if (labyrinth[col][row]){
					System.out.print('=');
				} else{
					System.out.print(".");
				}
			}
			// A newline after every row
			System.out.println();
		}
		// A newline between every update
		System.out.println();
		}
	}