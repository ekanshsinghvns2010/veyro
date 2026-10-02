package com.veyro.editor.core

import java.util.UUID

class ProjectController {

    var project: VeyroProject = createNewProject()
        private set

    var selectedLayerId: String? = null
        private set

    fun createNewProject(
        name: String = "Untitled Project"
    ): VeyroProject {

        val newProject = VeyroProject(
            id = UUID.randomUUID().toString(),
            name = name,
            composition = Composition()
        )

        project = newProject
        selectedLayerId = null

        return newProject
    }

    fun addVideo(
        name: String,
        mediaPath: String,
        durationMs: Long
    ) {

        val layer = Layer.Video(
            id = UUID.randomUUID().toString(),
            name = name,
            startTimeMs = 0L,
            durationMs = durationMs,
            mediaPath = mediaPath
        )

        updateLayers(
            project.composition.layers + layer
        )

        selectedLayerId = layer.id
    }

    fun addImage(
        name: String,
        mediaPath: String,
        durationMs: Long = 5_000L
    ) {

        val layer = Layer.Image(
            id = UUID.randomUUID().toString(),
            name = name,
            startTimeMs = 0L,
            durationMs = durationMs,
            mediaPath = mediaPath
        )

        updateLayers(
            project.composition.layers + layer
        )

        selectedLayerId = layer.id
    }

    fun addText(
        text: String
    ) {

        val layer = Layer.Text(
            id = UUID.randomUUID().toString(),
            name = "Text",
            startTimeMs = 0L,
            durationMs = 5_000L,
            text = text
        )

        updateLayers(
            project.composition.layers + layer
        )

        selectedLayerId = layer.id
    }

    fun addAudio(
        name: String,
        mediaPath: String,
        durationMs: Long
    ) {

        val layer = Layer.Audio(
            id = UUID.randomUUID().toString(),
            name = name,
            startTimeMs = 0L,
            durationMs = durationMs,
            mediaPath = mediaPath
        )

        updateLayers(
            project.composition.layers + layer
        )

        selectedLayerId = layer.id
    }

    fun selectLayer(layerId: String?) {
        selectedLayerId = layerId
    }

    fun removeSelectedLayer() {

        val selectedId = selectedLayerId ?: return

        updateLayers(
            project.composition.layers.filter {
                it.id != selectedId
            }
        )

        selectedLayerId = null
    }

    private fun updateLayers(
        layers: List<Layer>
    ) {

        project = project.copy(
            composition = project.composition.copy(
                layers = layers
            )
        )
    }
}