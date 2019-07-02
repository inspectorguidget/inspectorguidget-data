package fr.inria.inspectorguidget.data

data class HandlerInteraction(val handlers: List<Handler>) : Interaction {
    init {
        if (handlers.isEmpty()) {
            throw IllegalArgumentException("Must have at least one handler")
        }
    }

    override val type = "HandlerInteraction"
    override fun getName() = handlers[0].type
}