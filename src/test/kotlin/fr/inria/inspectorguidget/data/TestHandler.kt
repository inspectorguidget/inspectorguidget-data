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

class TestHandler {

    private lateinit var handler: Handler
    private var handlerParsed: Handler? = null

    @BeforeEach
    fun initialise() {

        val classref = ClassRef("file", "classname", "pkg")
        val location = Location(1, 2, classref)
        handler = Handler("type", location)

        val result = Klaxon().toJsonString(handler)
        handlerParsed = Klaxon().parse<Handler>(result)
    }

    @Test
    fun testType() {
        assertEquals(handler.type, handlerParsed?.type)
    }

    @Test
    fun testLocation() {
        assertEquals(handler.location, handlerParsed?.location)
    }
}