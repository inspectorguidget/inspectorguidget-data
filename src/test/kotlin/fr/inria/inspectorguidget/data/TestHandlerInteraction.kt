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

class TestHandlerInteraction {

    private lateinit var handlerInteraction: HandlerInteraction
    private var handlerInteractionParsed: HandlerInteraction? = null

    @BeforeEach
    fun init() {
        val handler = Handler("type", Location(1, 2, ClassRef("file", "classname", "pkg")))
        handlerInteraction = HandlerInteraction(listOf(handler))

        val result = Klaxon().toJsonString(handlerInteraction)
        handlerInteractionParsed = Klaxon().parse<HandlerInteraction>(result)
    }

    @Test
    fun testHandlers() {
        assertEquals(handlerInteraction.handlers, handlerInteractionParsed?.handlers)
    }
}