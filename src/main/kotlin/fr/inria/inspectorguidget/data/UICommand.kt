package fr.inria.inspectorguidget.data

data class UICommand(val widgets: List<Widget>, val location: Location, val uses: List<ClassRef>)
