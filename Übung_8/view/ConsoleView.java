package view;

import model.World;

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
		int startX = world.getStartX();
		int startY = world.getStartY();
		int destinationX = world.getDestinationX();
		int destinationY = world.getDestinationY();

		for (int row = 0; row < world.getHeight(); row++) {
			for (int col = 0; col < world.getWidth(); col++) {
				// If the player is here, print #, otherwise print .
				// Start and destination are marked as S and D
				if (row == playerY && col == playerX) {
					System.out.print("#");
				} else {
					if (row == startY && col == startX) {
						System.out.print('S');
					} else if (row == destinationY && col == destinationX) {
						System.out.print('D');
					} else {
						System.out.print(".");
					}
				}
			}

			// A newline after every row
			System.out.println();
		}

		// A newline between every update
		System.out.println();
	}

}
