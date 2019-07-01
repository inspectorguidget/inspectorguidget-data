package fr.inria.inspectorguidget.data

data class InteractoInteraction(val typeName: String) : Interaction {
    override fun getName() = typeName

}