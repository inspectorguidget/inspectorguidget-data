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

class TestClassRef {

    private lateinit var classref: ClassRef
    private var classrefParsed: ClassRef? = null

    @BeforeEach
    fun initialise() {
        classref = ClassRef("file", "classname", "pkg")
        val result = Klaxon().toJsonString(classref)
        classrefParsed = Klaxon().parse<ClassRef>(result)
    }

    @Test
    fun testFile() {
        assertEquals(classref.file, classrefParsed?.file)
    }

    @Test
    fun testClassName() {
        assertEquals(classref.className, classrefParsed?.className)
    }

    @Test
    fun testPkg() {
        assertEquals(classref.pkg, classrefParsed?.pkg)
    }
}