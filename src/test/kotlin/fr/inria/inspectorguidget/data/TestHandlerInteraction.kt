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