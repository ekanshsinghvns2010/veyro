package com.veyro.editor.core

enum class KeyframeProperty {
    POSITION_X,
    POSITION_Y,
    SCALE_X,
    SCALE_Y,
    ROTATION,
    OPACITY
}

enum class Easing {
    LINEAR,
    EASE_IN,
    EASE_OUT,
    EASE_IN_OUT
}

data class Keyframe(
    val timeMs: Long,
    val value: Float,
    val easing: Easing = Easing.LINEAR
)

data class AnimatedProperty(
    val property: KeyframeProperty,
    val keyframes: List<Keyframe> = emptyList()
)