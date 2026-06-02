package com.example.dungeondelverapp.views

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.dungeondelverapp.db.MapCell

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SquareTable(modifier: Modifier = Modifier) {
    var rowsInput by remember { mutableStateOf("") }
    var colsInput by remember { mutableStateOf("") }

    val rows = rowsInput.toIntOrNull() ?: 0
    val cols = colsInput.toIntOrNull() ?: 0

    // State to track which cell index is being edited (null means dialog is closed)
    var editingCellIndex by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Inputs Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = rowsInput,
                onValueChange = { rowsInput = it },
                label = { Text("Rows") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = colsInput,
                onValueChange = { colsInput = it },
                label = { Text("Columns") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }

        // Table Render Area
        if (rows > 0 && cols > 0) {
            // Using mutableStateListOf so Compose detects updates to individual elements
            val tableData = remember(rows, cols) {
                mutableStateListOf<MapCell>().apply {
                    addAll(
                        List(rows * cols) { index ->
                            MapCell(
                                height = 0,
                                cover = "none"
                            )
                        }
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(cols),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .border(1.dp, Color.Gray),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(tableData.size) { index ->
                    TableCell(
                        cell = tableData[index],
                        modifier = Modifier.clickable {
                            editingCellIndex = index // Open dialog for this cell
                        }
                    )
                }
            }

            // --- Edit Cell Dialog ---
            editingCellIndex?.let { index ->
                val cellToEdit = tableData[index]

                // Dialog local states initialized with current cell values
                var editHeight by remember { mutableStateOf(cellToEdit.height.toString()) }
                var editCover by remember { mutableStateOf(cellToEdit.cover) }

                AlertDialog(
                    onDismissRequest = { editingCellIndex = null },
                    title = { Text(text = "Edit Cell #${index + 1}") },
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            OutlinedTextField(
                                value = editHeight,
                                onValueChange = { editHeight = it },
                                label = { Text("Height") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier.fillMaxWidth()
                            )

                            Text("Cover Type:", style = MaterialTheme.typography.bodyMedium)

                            // Simple radio buttons for selection
                            val coverOptions = listOf("none", "half", "full")
                            coverOptions.forEach { option ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { editCover = option }
                                        .padding(vertical = 4.dp)
                                ) {
                                    RadioButton(
                                        selected = (editCover == option),
                                        onClick = { editCover = option }
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = option.replaceFirstChar { it.uppercase() })
                                }
                            }
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                val targetHeight = editHeight.toIntOrNull() ?: cellToEdit.height

                                // Update data source; resetting the element forces grid recomposition
                                tableData[index] = MapCell(height = targetHeight, cover = editCover)
                                editingCellIndex = null
                            }
                        ) {
                            Text("Save")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { editingCellIndex = null }) {
                            Text("Cancel")
                        }
                    }
                )
            }

        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text("Enter valid dimensions to generate the table", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun TableCell(cell: MapCell, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .aspectRatio(1f) // Enforces perfect square dimensions
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = when (cell.cover) {
                "full" -> MaterialTheme.colorScheme.primaryContainer
                "half" -> MaterialTheme.colorScheme.secondaryContainer
                else -> MaterialTheme.colorScheme.surfaceVariant
            }
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = cell.height.toString(),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = cell.cover,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}