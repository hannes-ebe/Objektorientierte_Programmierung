package view;

import model.World;

/**
 * Classes that want to display the {@link World} must implement this interface
 * to be notified when the world updates.
 */
public interface View {

	/**
	 * Called whenever the world updates.
	 * 
	 * @param world the {@link World} object which called this method.
	 */
	void update(World world);

	/**
	 * Called to check whether the player has reached the destination. If
	 * that is the case the game asks whether it should restart.
	 *
	 * @param world the {@link World} object which called this method.
	 */
	void isDestinationReached(World world);

}
