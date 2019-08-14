/*
 * This file is part of InspectorGuidget.
 * InspectorGuidget is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * InspectorGuidget is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with InspectorGuidget.  If not, see <https://www.gnu.org/licenses/>.
 */

package fr.inria.inspectorguidget.data

import com.beust.klaxon.Klaxon
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestLocation {

    private lateinit var location: Location
    private var locationParsed: Location? = null

    @BeforeEach
    fun initialise() {
        val classref = ClassRef("file", "className", "pkg")
        location = Location(1, 2, classref)
        val result = Klaxon().toJsonString(location)
        locationParsed = Klaxon().parse<Location>(result)
    }

    @Test
    fun testLineStart() {
        assertEquals(location.lineStart, locationParsed?.lineStart)
    }

    @Test
    fun testLineStop() {
        assertEquals(location.lineEnd, locationParsed?.lineEnd)
    }

    @Test
    fun testClassref() {
        assertEquals(location.classRef, locationParsed?.classRef)
    }
}