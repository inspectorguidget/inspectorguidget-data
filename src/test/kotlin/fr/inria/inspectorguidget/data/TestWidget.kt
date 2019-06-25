package fr.inria.inspectorguidget.data

import com.beust.klaxon.Klaxon
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestWidget {

    private lateinit var widget: Widget
    private var widgetParsed: Widget? = null

    @BeforeEach
    fun init() {

        val listLocation = listOf(Location(1, 2, ClassRef("file", "className", "pkg")))
        widget = Widget("id", "type", listLocation)

        val result = Klaxon().toJsonString(widget)
        widgetParsed = Klaxon().parse<Widget>(result)
    }

    @Test
    fun testId() {
        assertEquals(widget.id, widgetParsed?.id)
    }

    @Test
    fun testUsage() {
        assertEquals(widget.usages, widgetParsed?.usages)
    }

    @Test
    fun testType() {
        assertEquals(widget.type, widgetParsed?.type)
    }
}