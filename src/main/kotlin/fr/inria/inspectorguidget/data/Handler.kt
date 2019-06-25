package fr.inria.inspectorguidget.data

data class Handler (val type : String, val location : Location, val widgets : List<Widget>, val cmds : List<UICommand>)