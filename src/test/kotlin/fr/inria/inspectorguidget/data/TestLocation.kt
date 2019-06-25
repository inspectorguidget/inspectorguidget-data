package fr.inria.inspectorguidget.data

import com.beust.klaxon.Klaxon
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TestLocation {

    private lateinit var location: Location
    private var locationParsed: Location? = null

    @Before
    fun initialise() {
        val classref = ClassRef("file", "className", "pkg")
        location = Location(1, 2, classref)
        val result = Klaxon().toJsonString(location)
        locationParsed = Klaxon().parse<Location>(result)
    }

    @Test
    fun testLineStart() {
        assertEquals(location.lineStart, locationParsed?.lineStart)
    }

    @Test
    fun testLineStop() {
        assertEquals(location.lineEnd, locationParsed?.lineEnd)
    }

    @Test
    fun testClassref() {
        assertEquals(location.classRef, locationParsed?.classRef)
    }
}