package com.example.taskmanager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun TaskScreenContent(
    tasks: List<Task>,
    onAdd: (String) -> Unit,
    onDelete: (String) -> Unit,
    onToggle: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = tasks,
            key = { task -> task.id }  // critical — enables stable diffing
        ) { task ->
//            TaskItem(
//                task = task,
//                onToggle = { onToggle(task.id) },
//                onDelete = { onDelete(task.id) }
//            )
        }
    }
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