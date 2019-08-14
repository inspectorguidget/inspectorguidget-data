/*
 * This file is part of InspectorGuidget.
 * InspectorGuidget is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * InspectorGuidget is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with InspectorGuidget.  If not, see <https://www.gnu.org/licenses/>.
 */

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