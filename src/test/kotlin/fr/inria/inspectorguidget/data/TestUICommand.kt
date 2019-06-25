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
        val listWidget = listOf<Widget>()
        val classeref = ClassRef("file", "className", "pkg")
        val location = Location(1, 2, classeref)
        val uses = listOf(classeref)

        cmd = UICommand(listWidget, location, uses)

        val result = Klaxon().toJsonString(cmd)
        cmdParsed = Klaxon().parse<UICommand>(result)
    }

    @Test
    fun testWidget() {
        assertEquals(cmd.widgets, cmdParsed?.widgets)
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