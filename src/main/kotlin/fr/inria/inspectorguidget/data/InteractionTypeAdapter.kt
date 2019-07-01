package fr.inria.inspectorguidget.data

import com.beust.klaxon.TypeAdapter
import kotlin.reflect.KClass

class InteractionTypeAdapter : TypeAdapter<Interaction> {
    override fun classFor(type: Any): KClass<out Interaction> = when (type as String) {
        "IntercatoInteraction" -> InteractoInteraction::class
        "HandlerInteraction" -> HandlerInteraction::class
        else -> throw IllegalArgumentException("Unknown type: $type")
    }
}