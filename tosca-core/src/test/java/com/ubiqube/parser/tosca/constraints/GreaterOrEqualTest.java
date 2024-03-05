/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.parser.tosca.constraints;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.ubiqube.parser.tosca.ParseException;

class GreaterOrEqualTest {

	@Test
	void test() {
		final GreaterOrEqual srv = new GreaterOrEqual();
		srv.setValue("1");
		assertFalse((boolean) srv.evaluate(112));
		assertTrue((boolean) srv.evaluate(1));
		assertTrue((boolean) srv.evaluate(1D));
		assertFalse((boolean) srv.evaluate(111D));
		assertFalse((boolean) srv.evaluate(List.of()));
		assertTrue((boolean) srv.evaluate(List.of("", "")));
	}

	@Test
	void testNull() {
		final GreaterOrEqual srv = new GreaterOrEqual();
		srv.setValue("11");
		assertThrows(NullPointerException.class, () -> srv.evaluate(null));
	}

	@Test
	void testOther() {
		final GreaterOrEqual srv = new GreaterOrEqual();
		srv.setValue("11");
		final Map<Object, Object> map = Map.of();
		assertThrows(ParseException.class, () -> srv.evaluate(map));
	}
}
