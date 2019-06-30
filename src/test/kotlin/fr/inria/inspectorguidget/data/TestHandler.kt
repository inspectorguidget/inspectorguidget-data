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