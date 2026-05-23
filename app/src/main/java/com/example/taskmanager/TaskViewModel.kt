package com.example.taskmanager

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskViewModel: ViewModel() {
    private val _tasks = MutableStateFlow(listOf<Task>())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    fun addTask(title: String) {
        val newTask = Task(title = title)
        _tasks.value = _tasks.value + newTask
    }

    fun deleteTask(id: String) {
        _tasks.value = _tasks.value.filter { it.id != id }
    }

    fun toggleComplete(id: String) {
        _tasks.value = _tasks.value.map { task ->
            if (task.id == id) {
                task.copy(isComplete = !task.isComplete)
            } else {
                task
            }
        }
    }
}