/***************************************************************************
 * Copyright (C) 2022 VL Objekt-orientierte Programmierung, Kiel University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/
package reservation.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.*;

/**
 * Reservation System.
 *
 * @author Reiner Jung
 * @since 1.0
 */
public class ReservationSystem {

	private static final String DATABASE_FILENAME = "reservations.json";

	// private final Scanner scanner;
	// private final Output output;
	private final Reservations reservations;

	private final JFrame mainWindow;
	/** number of rooms */
	private static final int NUMBER_OF_ROOMS = 10;
	/* rows and columns in which wooms are ordered in main window */
	private static final int ROOM_COLUMNS = 5;
	private static final int ROOM_ROWS = 2;

	public static void main(final String[] args) {
		try {
			final ReservationSystem rs = new ReservationSystem(10);
			// rs.run();

			// Create main window
			rs.createMainWindow();

			rs.save();
		} catch (IOException | LoadException e) {
			System.err.println("Startup error.");
		}
	}

	private void save() throws IOException {
		this.reservations.save(Path.of(DATABASE_FILENAME));
	}

	public ReservationSystem(final int numberOfRooms) throws IOException, LoadException {
		this.mainWindow = createMainWindow();

		final Path filename = Path.of(DATABASE_FILENAME);
		if (filename.toFile().exists() && filename.toFile().canRead()) {
			try {
				this.reservations = new Reservations(filename);
			} catch (final IOException e) {
				System.err.printf("Cannot read database %s %s\n", DATABASE_FILENAME, e.getMessage());
				throw e; // Relay exception
			} catch (final LoadException e) {
				System.err.printf("Cannot process database %s %s\n", DATABASE_FILENAME, e.getMessage());
				throw e; // Relay exception
			}
		} else {
			this.reservations = new Reservations(numberOfRooms);
		}
		this.mainWindow.setVisible(true);
	}

	/*
	public ReservationSystem(final int numberOfRooms) throws IOException, LoadException {
		this.scanner = new Scanner(System.in);
		this.output = new Output();

		final Path filename = Path.of(DATABASE_FILENAME);
		if (filename.toFile().exists() && filename.toFile().canRead()) {
			try {
				this.reservations = new Reservations(filename);
			} catch (final IOException e) {
				this.output.message("Cannot read database " + DATABASE_FILENAME + " " + e.getMessage());
				throw e; // Relay exception
			} catch (final LoadException e) {
				this.output.message("Cannot process database " + DATABASE_FILENAME + " " + e.getMessage());
				throw e; // Relay exception
			}
		} else {
			this.reservations = new Reservations(numberOfRooms);
		}
	} */

	/** Create the main window */
	private JFrame createMainWindow() {
		JFrame mainWindow = new JFrame("Reservation System");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setPreferredSize(new Dimension(500,120));
		mainWindow.setResizable(false);
		mainWindow.setLayout(new GridLayout(2,1));

		// buttons for different actions
		JPanel menuButtons = new JPanel();
		menuButtons.setLayout(new FlowLayout());

		JButton listFree = new JButton("List Free");
		JButton listOccupied = new JButton("List Occupied");
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuButtons.add(listFree);
		menuButtons.add(listOccupied);
		menuButtons.add(exit);

		// buttons for different rooms
		JPanel roomButtons = new JPanel();
		roomButtons.setLayout(new GridLayout(ROOM_ROWS,ROOM_COLUMNS));
		for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
			JButton newRoom = new JButton("Room " + i);
			roomButtons.add(newRoom);
		}

		mainWindow.add(menuButtons);
		mainWindow.add(roomButtons);

		mainWindow.pack();
		mainWindow.setLocationRelativeTo(null);

		return mainWindow;
	}

	/** Create a window for the room overview */
	private JFrame createRoomOverview() {
		JFrame roomOverview = new JFrame("Room Overview");
		roomOverview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		roomOverview.setPreferredSize(new Dimension(500,120));
		roomOverview.setResizable(false);
		roomOverview.setLayout(new GridLayout(2,1));

		//ScrollPane für Liste und die drei Buttons...

		return roomOverview;
	}

	/** Create a window to enter a date range */
	private JFrame createTimeWindow() {
		JFrame timeWindow = new JFrame("Enter Time Period");

		return timeWindow;
	}

	/*
	private void run() {
		boolean active = true;

		this.output.header("Welcome to the reservation system");
		this.output.message("Get help by typing help.");

		while (active) {
			final String command = this.scanner.next("\\S*");
			if ("exit".equals(command)) {
				active = false;
			} else if ("help".equals(command)) {
				this.printHelp();
			} else if ("res".equals(command)) {
				this.reserveRoom();
			} else if ("free".equals(command)) {
				this.freeRoom();
			} else if ("find-free".equals(command)) {
				this.findFreeRoom();
			} else if ("list-free".equals(command)) {
				this.listFreeRooms();
			} else if ("list-occupied".equals(command)) {
				this.listOccupiedRooms();
			}
		}
	}

	private void printHelp() {
		this.output.header("Commands");

		this.output.message("res <number> <start-date> <end-date>   reserve room");
		this.output.message("free <number>  <start-date>            make room free");
		this.output.message("find-free <start-date> <end-date>      return next free room");
		this.output.message("list-free <start-date> <end-date>      list all free rooms");
		this.output.message("list-occupied <start-date> <end-date>  list all reserved rooms");
		this.output.message("help                                   show this screen");
		this.output.message("exit                                   end program");
	}


	private void reserveRoom() {
		final int room = this.scanner.nextInt();
		final DateRange dateRange = this.createDateRange(this.scanner);

		try {
			if (this.reservations.reserveRoom(room, dateRange)) {
				this.output.printValue("Booked", room);
				this.save();
			} else {
				this.output.message("Room already booked");
			}
		} catch (final RoomOutOfRangeException ex) {
			this.output.message("Error: " + ex.getMessage());
		} catch (final IOException e) {
			this.output.message("IO Error: " + e.getMessage());
		}
	}

	private void freeRoom() {
		final int room = this.scanner.nextInt();

		try {
			if (this.reservations.freeRoom(room, this.createDate(this.scanner))) {
				this.output.printValue("Room freed", room);
				this.save();
			} else {
				this.output.message("Room was not booked.");
			}
		} catch (final RoomOutOfRangeException ex) {
			this.output.message("Error: " + ex.getMessage());
		} catch (final IOException e) {
			this.output.message("IO Error: " + e.getMessage());
		}
	}

	private void findFreeRoom() {
		final Integer roomNumber = this.reservations.findFreeRoom(this.createDateRange(this.scanner));
		if (roomNumber != null) {
			this.output.printValue("Next free room", roomNumber);
		} else {
			this.output.message("All rooms are occupied");
		}
	}

	private void listFreeRooms() {
		this.output.printList("Free", this.reservations.listFreeRooms(this.createDateRange(this.scanner)));
	}

	private void listOccupiedRooms() {
		this.output.printList("Occupied", this.reservations.listOccupiedRooms(this.createDateRange(this.scanner)));
	}

	private DateRange createDateRange(final Scanner scanner) {
		final LocalDate firstDate = this.createDate(this.scanner);
		final LocalDate lastDate = this.createDate(this.scanner);

		return new DateRange(firstDate, lastDate);
	}

	private LocalDate createDate(final Scanner scanner) {
		final String dateString = scanner.next("\\d+-\\d+-\\d+");
		final String[] dateParts = dateString.split("-");

		return LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]),
				Integer.parseInt(dateParts[0]));
	}
	*/
}
