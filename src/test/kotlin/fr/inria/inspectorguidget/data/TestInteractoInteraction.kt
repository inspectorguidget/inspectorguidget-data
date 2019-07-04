package fr.inria.inspectorguidget.data

import com.beust.klaxon.Klaxon
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestInteractoInteraction {

    private lateinit var interactoInteraction: InteractoInteraction
    private var interactoInteractionParsed: InteractoInteraction? = null

    @BeforeEach
    fun init() {
        interactoInteraction = InteractoInteraction("typeName")
        val result = Klaxon().toJsonString(interactoInteraction)
        interactoInteractionParsed = Klaxon().parse<InteractoInteraction>(result)
    }

    @Test
    fun testTypeName() {
        assertEquals(interactoInteraction.typeName, interactoInteractionParsed?.typeName)
    }
}