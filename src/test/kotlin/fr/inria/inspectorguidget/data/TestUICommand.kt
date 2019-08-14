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

class TestUICommand {

    private lateinit var cmd: UICommand
    private var cmdParsed: UICommand? = null

    @BeforeEach
    fun init() {
        val classeref = ClassRef("file", "className", "pkg")
        val location = Location(1, 2, classeref)
        val uses = listOf(classeref)

        cmd = UICommand(location, uses)

        val result = Klaxon().toJsonString(cmd)
        cmdParsed = Klaxon().parse<UICommand>(result)
    }

    @Test
    fun testLocation() {
        assertEquals(cmd.location, cmdParsed?.location)
    }

    @Test
    fun testUses() {
        assertEquals(cmd.uses, cmdParsed?.uses)
    }
}