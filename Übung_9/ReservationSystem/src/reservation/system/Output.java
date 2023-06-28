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

import java.util.List;

/**
 * Handle the output of the reservation system.
 *
 * @author Reiner Jung
 * @since 1.0
 */
public class Output {

	public void header(final String header) {
		System.out.println(header);
		for (int i = 0; i < header.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void message(final String message) {
		System.out.println(message);
	}

	public void printList(final String label, final List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%s: %d\n", label, list.get(i));
		}
	}

	public void printValue(final String label, final Integer element) {
		System.out.printf("%s: %d\n", label, element);
	}
}
