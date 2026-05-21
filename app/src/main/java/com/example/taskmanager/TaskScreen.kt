package com.example.taskmanager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun TaskScreenContent(
    tasks: List<Task>,
    onAdd: (String) -> Unit,
    onDelete: (String) -> Unit,
    onToggle: (String) -> Unit
) {
    TODO("Not yet implemented")
}

@Composable
fun TaskScreen(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsStateWithLifecycle()

    TaskScreenContent(
        tasks = tasks,
        onAdd = viewModel::addTask,
        onDelete = viewModel::deleteTask,
        onToggle = viewModel::toggleComplete
    )
}