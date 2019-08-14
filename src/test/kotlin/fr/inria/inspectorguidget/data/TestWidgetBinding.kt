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
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestWidgetBinding {

    private lateinit var widgetBinding: WidgetBinding
    private var widgetBindingParsed: WidgetBinding? = null

    @BeforeEach
    fun initialise() {
        val classref = ClassRef("file", "classname", "pkg")
        val location = Location(1, 3, classref)
        val widgets = listOf(Widget("id", "type", listOf(location)))

        val interaction: Interaction = InteractoInteraction("typeName")

        widgetBinding = WidgetBinding(interaction, widgets, UICommand(location, listOf(classref)))

        val result = Klaxon().toJsonString(widgetBinding)

        widgetBindingParsed = Klaxon().parse<WidgetBinding>(result)
    }

    @Test
    fun testCmd() {
        Assertions.assertEquals(widgetBinding.cmd, widgetBindingParsed?.cmd)
    }

    @Test
    fun testInteraction() {
        Assertions.assertEquals(widgetBinding.interaction, widgetBindingParsed?.interaction)
    }

    @Test
    fun testWidgets() {
        Assertions.assertEquals(widgetBinding.widgets, widgetBindingParsed?.widgets)
    }
}