import com.beust.klaxon.Klaxon
import fr.inria.inspectorguidget.data.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TestHandler {

    private lateinit var handler: Handler
    private var handlerParsed: Handler? = null

    @Before
    fun initialise() {

        val classref = ClassRef("file", "classname", "pkg")
        val location = Location(1, 2, classref)
        val listWidget = listOf(Widget("id", "type", listOf(location)))
        val listCmd = listOf<UICommand>()
        handler = Handler("type", location, listWidget, listCmd)

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

    @Test
    fun testWidget() {
        assertEquals(handler.widgets, handlerParsed?.widgets)
    }

    @Test
    fun testCmd() {
        assertEquals(handler.cmds, handlerParsed?.cmds)
    }
}