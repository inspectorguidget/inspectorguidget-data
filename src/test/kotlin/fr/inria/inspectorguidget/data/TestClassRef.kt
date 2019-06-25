package fr.inria.inspectorguidget.data

import com.beust.klaxon.Klaxon
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TestClassRef {

    private lateinit var classref: ClassRef
    private var classrefParsed: ClassRef? = null

    @Before
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