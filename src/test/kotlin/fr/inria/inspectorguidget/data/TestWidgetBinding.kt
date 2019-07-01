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

        val interaction  : Interaction = InteractoInteraction("typeName")

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