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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Reiner Jung
 * @since 1.0
 */
public class Room implements Storable {

	final int roomNumber;
	final List<DateRange> reservations = new ArrayList<DateRange>();

	/**
	 * Creates a room object with a specific number.
	 *
	 * @param roomNumber room number
	 */
	public Room(final int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Room(final String data) throws LoadException {
		final Pattern pattern = Pattern.compile("\\{ number: (\\d+), \\[(.*)\\] \\}");
		final Matcher matcher = pattern.matcher(data);
		if (matcher.matches()) {
			this.roomNumber = Integer.parseInt(matcher.group(1));
			for (final String date : matcher.group(2).split(";")) {
				if (date.trim().length() > 0) {
					this.reservations.add(new DateRange(date.trim()));
				}
			}
		} else {
			throw new LoadException("Cannot parse room info " + data);
		}
	}

	/**
	 *
	 * @param date date range where we want to know whether the room is occupied.
	 *
	 * @return returns true when the room is occupied
	 */
	public boolean isOccupied(final DateRange dateRange) {
		for (final DateRange range : this.reservations) {
			if (range.isInRange(dateRange)) {
				return true;
			}
		}
		return false;
	}

	public boolean bookRoom(final DateRange dateRange) {
		if (this.isOccupied(dateRange)) {
			return false;
		} else {
			this.reservations.add(dateRange);
			return true;
		}
	}

	public int getRoomNumber() {
		return this.roomNumber;
	}

	public boolean freeRoom(final LocalDate date) {
		final DateRange dateRange = this.findDateRangeByStartDate(date);
		if (dateRange != null) {
			this.reservations.remove(dateRange);
			return true;
		} else {
			return false;
		}
	}

	private DateRange findDateRangeByStartDate(final LocalDate date) {
		for (final DateRange range : this.reservations) {
			if (range.getFirstDate().equals(date)) {
				return range;
			}
		}
		return null;
	}

	@Override
	public String save() {
		String dates = "";
		for (final DateRange reservation : this.reservations) {
			dates += reservation.save();
			dates += "; ";
		}
		if (dates.length() > 0) {
			dates = dates.substring(0, dates.length() - 2);
		}
		return String.format("{ number: %d, [ %s ] }\n", this.roomNumber, dates);
	}

}
