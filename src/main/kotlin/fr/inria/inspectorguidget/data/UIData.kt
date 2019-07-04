package fr.inria.inspectorguidget.data

import java.util.stream.Collectors

data class UIData(val widgetBindings: List<WidgetBinding>) {
    fun getInteractions(): Set<Interaction> =
        widgetBindings
            .stream()
            .map { wb -> wb.interaction }
            .collect(Collectors.toSet())

    fun getCommands(): Set<UICommand> =
        widgetBindings
            .stream()
            .map { wb -> wb.cmd }
            .collect(Collectors.toSet())
}
