package fr.inria.inspectorguidget.data

/**
 * A user interaction.
 * Is abstract since different implementations exit
 */
interface Interaction {
    /**
     * Returns the name of the user interaction.
     */
    fun getName(): String
}
