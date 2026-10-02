package com.veyro.editor.core

data class VeyroProject(
    val id: String,
    val name: String,
    val composition: Composition
)

data class Composition(
    val width: Int = 1920,
    val height: Int = 1080,
    val frameRate: Int = 30,
    val durationMs: Long = 10_000L,
    val layers: List<Layer> = emptyList()
)

sealed class Layer {

    abstract val id: String
    abstract val name: String
    abstract val startTimeMs: Long
    abstract val durationMs: Long
    abstract val transform: Transform
    abstract val opacity: Float

    data class Video(
        override val id: String,
        override val name: String,
        override val startTimeMs: Long,
        override val durationMs: Long,
        override val transform: Transform = Transform(),
        override val opacity: Float = 1f,
        val mediaPath: String
    ) : Layer()

    data class Image(
        override val id: String,
        override val name: String,
        override val startTimeMs: Long,
        override val durationMs: Long,
        override val transform: Transform = Transform(),
        override val opacity: Float = 1f,
        val mediaPath: String
    ) : Layer()

    data class Text(
        override val id: String,
        override val name: String,
        override val startTimeMs: Long,
        override val durationMs: Long,
        override val transform: Transform = Transform(),
        override val opacity: Float = 1f,
        val text: String,
        val fontSize: Float = 48f
    ) : Layer()

    data class Audio(
        override val id: String,
        override val name: String,
        override val startTimeMs: Long,
        override val durationMs: Long,
        override val transform: Transform = Transform(),
        override val opacity: Float = 1f,
        val mediaPath: String,
        val volume: Float = 1f
    ) : Layer()
}

data class Transform(
    val positionX: Float = 0f,
    val positionY: Float = 0f,
    val scaleX: Float = 1f,
    val scaleY: Float = 1f,
    val rotation: Float = 0f,
    val anchorX: Float = 0f,
    val anchorY: Float = 0f
)