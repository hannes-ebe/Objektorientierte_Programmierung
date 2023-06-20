package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Font;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
		for (int i = 0; i < 3; i++) {
			this.pursuers.add(new Rectangle(1,1));
		}
	}

	/** The background rectangle. */
	private final Rectangle bg;
	/** The player we're moving. */
	private final Rectangle player = new Rectangle(1, 1);
	/** Array List of pursuers. */
	private final ArrayList<Rectangle> pursuers = new ArrayList<>();
	/** Labyrinth of game world. */
	private boolean[][] labyrinth;

	/**
	 * Creates a new instance.
	 */
	@Override
	public void paint(Graphics g) {

		// Paint background
		g.setColor(Color.RED);
		g.fillRect(bg.x, bg.y, bg.width, bg.height);

		// Create new font with bigger size to mark player and pursuers.
		Font font = new Font("Arial", Font.BOLD, 24);
		g.setFont(font);

		// Painting objects in order of importance. This way the player is always on top of
		// every other object and the pursuers over start and destination.

		// Painting the walls as black squares.
		g.setColor(Color.BLACK);
		for (int row = 0; row < labyrinth.length; row++) {
			for (int col = 0; col < labyrinth.length; col++) {
				if (labyrinth[col][row]) {
					g.fillRect(col * fieldDimension.width,row * fieldDimension.height, fieldDimension.width, fieldDimension.height);
				}
			}
		}

		// Painting the start and destination as S and D, if they are not covered by the player.
		// Start is the upper left rectangle and the destination the bottom right
		char[] startLabel = new char[1];
		startLabel[0] = 'S';
		char[] destinationLabel = new char[1];
		destinationLabel[0] = 'D';
		g.setColor(Color.WHITE);
		g.drawChars(startLabel, 0, 1, player.width / 5, player.height - player.height / 8);
		g.drawChars(destinationLabel, 0, 1, bg.width - 4 * player.width / 5, bg.height - player.height / 8);


		// Painting the pursuers as black circles with an X.
		char[] pursuerLabel = new char[1];
		pursuerLabel[0] = 'X';
		for (Rectangle pursuer: pursuers) {
			g.setColor(Color.BLACK);
			g.fillOval(pursuer.x, pursuer.y, pursuer.width, pursuer.height);
			g.setColor(Color.WHITE);
			g.drawChars(pursuerLabel, 0, 1, pursuer.x + pursuer.width / 5, pursuer.y + pursuer.height - pursuer.height / 8);
		}

		// Paint player as a black circle with white P
		char[] playerLabel = new char[1];
		playerLabel[0] = 'P';
		g.setColor(Color.BLUE);
		g.fillOval(player.x, player.y, player.width, player.height);
		g.setColor(Color.WHITE);
		g.drawChars(playerLabel,0,1,player.x + player.width / 5,player.y + player.height - player.height / 8);

	}

	@Override
	public void update(World world) {

		// Update players size and location
		player.setSize(fieldDimension);
		player.setLocation((int)
						(world.getPlayerX() * fieldDimension.width),
				(int) (world.getPlayerY() * fieldDimension.height));
		// Update size and location of pursuers
		int i = 0;
		for (Rectangle pursuer: pursuers) {
			pursuer.setSize(fieldDimension);
			pursuer.setLocation((int)
							(world.getPursuer(i).getX() * fieldDimension.width),
					(int) (world.getPursuer(i).getY() * fieldDimension.height));
			i++;
		}
		// Get Labyrinth
		labyrinth = world.getLabyrinth();

		repaint();
	}

}
