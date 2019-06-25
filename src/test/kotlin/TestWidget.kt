import com.beust.klaxon.Klaxon
import fr.inria.inspectorguidget.data.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TestWidget {

    private lateinit var widget : Widget
    private var widgetParsed : Widget? = null

    @Before
    fun init(){

        val listLocation = listOf(Location(1,2,ClassRef("file", "className", "pkg")))
        widget = Widget("id", "type", listLocation)

        val result = Klaxon().toJsonString(widget)
        widgetParsed = Klaxon().parse<Widget>(result)
    }

    @Test
    fun testId(){
        assertEquals(widget.id, widgetParsed?.id)
    }

    @Test
    fun testUsage(){
        assertEquals(widget.usages, widgetParsed?.usages)
    }

    @Test
    fun testType(){
        assertEquals(widget.type, widgetParsed?.type)
    }



}