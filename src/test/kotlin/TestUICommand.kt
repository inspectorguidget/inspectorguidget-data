import com.beust.klaxon.Klaxon
import fr.inria.inspectorguidget.data.*
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class TestUICommand {

    private lateinit var cmd : UICommand
    private var cmdParsed : UICommand? = null

    @Before
    fun init(){
        val listWidget = listOf<Widget>()
        val classeref = ClassRef("file","className", "pkg")
        val location = Location(1,2,classeref)
        val uses = listOf(classeref)
        cmd = UICommand(listWidget, location, uses)

        val result = Klaxon().toJsonString(cmd)
        cmdParsed = Klaxon().parse<UICommand>(result)
    }

    @Test
    fun testWidget(){
        assertEquals(cmd.widgets, cmdParsed?.widgets)
    }

    @Test
    fun testLocation(){
        assertEquals(cmd.location, cmdParsed?.location)
    }

    @Test
    fun testUses(){
        assertEquals(cmd.uses, cmdParsed?.uses)
    }
}