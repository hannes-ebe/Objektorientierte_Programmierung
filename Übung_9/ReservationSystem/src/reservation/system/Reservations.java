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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Reservation management.
 *
 * @author Reiner Jung
 * @since 1.0
 */
public class Reservations {

	final List<Room> rooms;

	/**
	 * Initialize the reservation system for a specific number of rooms.
	 *
	 * @param numberOfRooms number of rooms in the hotel.
	 */
	public Reservations(final int numberOfRooms) {
		this.rooms = new ArrayList<Room>();
		for (int i = 0; i < numberOfRooms; i++) {
			this.rooms.add(new Room(i));
		}
	}

	/**
	 * Initialize the reservation system based on information in the room file.
	 *
	 * @param numberOfRooms number of rooms in the hotel.
	 */
	public Reservations(final Path filename) throws IOException, LoadException {
		this.rooms = new ArrayList<Room>();
		this.load(filename);
	}

	/**
	 * @return returns the next free room for a given date range
	 */
	public Integer findFreeRoom(final DateRange dateRange) {
		for (int i = 0; i < this.rooms.size(); i++) {
			if (!this.rooms.get(i).isOccupied(dateRange)) {
				return i;
			}
		}
		return null;
	}

	/**
	 * @return returns a list of free rooms for a given date range.
	 */
	public List<Integer> listFreeRooms(final DateRange dateRange) {
		final List<Integer> result = new ArrayList<Integer>(this.rooms.size());
		for (int i = 0; i < this.rooms.size(); i++) {
			if (!this.rooms.get(i).isOccupied(dateRange)) {
				result.add(i);
			}
		}
		return result;
	}
	/**
	 * @return returns a list of occupied rooms for a given data range
	 */
	public List<Integer> listOccupiedRooms(final DateRange dateRange) {
		final List<Integer> result = new ArrayList<Integer>(this.rooms.size());
		for (int i = 0; i < this.rooms.size(); i++) {
			if (this.rooms.get(i).isOccupied(dateRange)) {
				result.add(i);
			}
		}
		return result;
	}

	/**
	 * Revoke a reservation for a room specified by the roomNumber starting with the given date.
	 *
	 * @param roomNumber the room number
	 * @param date start date of the reservation
	 * 
	 * @return returns true when the room is successfully reserved
	 */
	public boolean freeRoom(final int roomNumber, final LocalDate date) throws RoomOutOfRangeException {
		if ((roomNumber >= 0) && (roomNumber < this.rooms.size())) {
			final Room room = this.rooms.get(roomNumber);
			return room.freeRoom(date);
		} else {
			throw new RoomOutOfRangeException(roomNumber + " does not refer to a room in the hotel");
		}
	}

	/**
	 * Reserve a room specified by the roomNumber for the given date range.
	 *
	 * @param roomNumber the room number
	 * @param dateRange the first and last date of the reservation
	 * 
	 * @return returns true when the room is successfully reserved
	 */
	public boolean reserveRoom(final int roomNumber, final DateRange dateRange) throws RoomOutOfRangeException {
		if ((roomNumber >= 0) && (roomNumber < this.rooms.size())) {
			final Room room = this.rooms.get(roomNumber);
			if (!room.isOccupied(dateRange)) {
				room.bookRoom(dateRange);
				return true;
			} else {
				return false;
			}
		} else {
			throw new RoomOutOfRangeException(roomNumber + " does not refer to a room in the hotel");
		}
	}

	/**
	 * Save all room information in the file specified by filename.
	 *
	 * @param filename filename of the file where the room information is stored.
	 */
	public void save(final Path filename) throws IOException {
		final BufferedWriter writer = Files.newBufferedWriter(filename);
		for (final Room room : this.rooms) {
			writer.write(room.save());
		}
		writer.close();
	}

	/**
	 * Load room information from a file.
	 *
	 * @param filename path to the file containing the room information.
	 */ 
	private void load(final Path filename) throws IOException, LoadException {
		final BufferedReader reader = Files.newBufferedReader(filename);
		String line;
		while ((line = reader.readLine()) != null) {
			final Room room = new Room(line);
			this.rooms.add(room);
		}
		reader.close();
	}
}
