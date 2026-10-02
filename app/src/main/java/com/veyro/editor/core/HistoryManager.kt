package com.veyro.editor.core

class HistoryManager<T>(
    private val maxHistory: Int = 100
) {

    private val undoStack = ArrayDeque<T>()
    private val redoStack = ArrayDeque<T>()

    fun record(state: T) {
        undoStack.addLast(state)

        if (undoStack.size > maxHistory) {
            undoStack.removeFirst()
        }

        redoStack.clear()
    }

    fun undo(currentState: T): T? {

        if (undoStack.isEmpty()) {
            return null
        }

        val previousState = undoStack.removeLast()

        redoStack.addLast(currentState)

        return previousState
    }

    fun redo(currentState: T): T? {

        if (redoStack.isEmpty()) {
            return null
        }

        val nextState = redoStack.removeLast()

        undoStack.addLast(currentState)

        return nextState
    }

    fun canUndo(): Boolean {
        return undoStack.isNotEmpty()
    }

    fun canRedo(): Boolean {
        return redoStack.isNotEmpty()
    }

    fun clear() {
        undoStack.clear()
        redoStack.clear()
    }
}