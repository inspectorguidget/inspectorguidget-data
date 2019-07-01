package fr.inria.inspectorguidget.data

import com.beust.klaxon.TypeFor

/**
 * A user interaction.
 * Is abstract since different implementations exit
 */
@TypeFor(field = "type", adapter = InteractionTypeAdapter::class)
interface Interaction {
    val type: String
    /**
     * Returns the name of the user interaction.
     */
    fun getName(): String
}
