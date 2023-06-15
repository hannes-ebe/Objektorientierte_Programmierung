package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JPanel;

import model.World;

/**
 * A graphical view of the world.
 */
public class GraphicView extends JPanel implements View {
	
	/** The view's width. */
	private final int WIDTH;
	/** The view's height. */
	private final int HEIGHT;
	
	private Dimension fieldDimension;
	
	public GraphicView(int width, int height, Dimension fieldDimension) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.fieldDimension = fieldDimension;
		this.bg = new Rectangle(WIDTH, HEIGHT);
	}
	
	/** The background rectangle. */
	private final Rectangle bg;
	/** The rectangle we're moving. */
	private final Rectangle player = new Rectangle(1, 1);
	
	/**
	 * Creates a new instance.
	 */
	@Override
	public void paint(Graphics g) {

		// Paint background
		g.setColor(Color.RED);
		g.fillRect(bg.x, bg.y, bg.width, bg.height);

		// Paint player as a black circle with white P
		char[] playerLabel = new char[1];
		playerLabel[0] = 'P';
		g.setColor(Color.BLACK);
		g.fillOval(player.x, player.y, player.width, player.height);
		g.setColor(Color.WHITE);
		// Create new font with bigger size to mark player with P
		Font font = new Font("Arial", Font.BOLD, 48);
		g.setFont(font);
		g.drawChars(playerLabel,0,1,player.x + player.width / 5,player.y + player.height - player.height / 8);

		// Painting the start and destination as S and D, if they are not covered by the player.
		// Start is the upper left rectangle and the destination the bottom right
		char[] startLabel = new char[1];
		startLabel[0] = 'S';
		char[] destinationLabel = new char[1];
		destinationLabel[0] = 'D';
		if (!(player.x == bg.x && player.y == bg.y)) {
			g.drawChars(startLabel, 0, 1, player.width / 5, player.height - player.height / 8);
		}
		if (!(player.x == bg.width - player.width && player.y == bg.height - player.height)) {
			g.drawChars(destinationLabel, 0, 1, bg.width - 4 * player.width / 5, bg.height - player.height / 8);
		}
	}

	@Override
	public void update(World world) {
		
		// Update players size and location
		player.setSize(fieldDimension);
		player.setLocation((int)
				(world.getPlayerX() * fieldDimension.width),
				(int) (world.getPlayerY() * fieldDimension.height));
		repaint();
	}
	
}
