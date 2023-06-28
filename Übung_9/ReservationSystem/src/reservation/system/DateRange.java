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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Reiner Jung
 * @since 1.0
 */
public class DateRange implements Storable {

	final LocalDate firstDate;
	final LocalDate lastDate;

	/**
	 * Creates a date range object.
	 *
	 * @param firstDate first date of the range
	 * @param lastDate  last date of the range
	 */
	public DateRange(final LocalDate firstDate, final LocalDate lastDate) {
		this.firstDate = firstDate;
		this.lastDate = lastDate;
	}

	/**
	 * Creates a date range object from a serialization string.
	 *
	 * @param data the string containing both dates
	 */
	public DateRange(final String data) throws LoadException {
		final Pattern pattern = Pattern
				.compile("\\{ firstDate:(\\d+)-(\\d+)-(\\d+), lastDate:(\\d+)-(\\d+)-(\\d+) \\}");
		final Matcher matcher = pattern.matcher(data);
		if (matcher.matches()) {
			this.firstDate = LocalDate.of(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)),
					Integer.parseInt(matcher.group(3)));
			this.lastDate = LocalDate.of(Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)),
					Integer.parseInt(matcher.group(6)));
		} else {
			throw new LoadException("Cannot parse date info " + data);
		}
	}

	public LocalDate getFirstDate() {
		return this.firstDate;
	}

	public LocalDate getLastDate() {
		return this.lastDate;
	}

	/**
	 * Checks whether the given date is between firstDate and lastDate including
	 * first and last date.
	 *
	 * @param dateRange date to be checked
	 * @return returns true if the date is in range else false
	 */
	public boolean isInRange(final DateRange dateRange) {
		if ((this.firstDate.isAfter(dateRange.getFirstDate()) && this.firstDate.isBefore(dateRange.getLastDate()))
				|| this.firstDate.equals(dateRange.getFirstDate()) || this.firstDate.equals(dateRange.getLastDate())) {
			return true;
		}
		if ((this.lastDate.isAfter(dateRange.getFirstDate()) && this.lastDate.isBefore(dateRange.getLastDate()))
				|| this.lastDate.equals(dateRange.getFirstDate()) || this.lastDate.equals(dateRange.getLastDate())) {
			return true;
		}
		if ((this.firstDate.isBefore(dateRange.getFirstDate()) && this.lastDate.isAfter(dateRange.getFirstDate()))
				|| (this.firstDate.isBefore(dateRange.getLastDate())
						&& this.lastDate.isAfter(dateRange.getLastDate()))) {
			return true;
		}
		return false;
	}

	@Override
	public String save() {
		return String.format("{ firstDate:%d-%d-%d, lastDate:%d-%d-%d }", this.firstDate.getYear(),
				this.firstDate.getMonthValue(), this.firstDate.getDayOfMonth(), this.lastDate.getYear(),
				this.lastDate.getMonthValue(), this.lastDate.getDayOfMonth());
	}

}
