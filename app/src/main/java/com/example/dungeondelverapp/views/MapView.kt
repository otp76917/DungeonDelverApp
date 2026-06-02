package com.example.dungeondelverapp.views

import androidx.compose.foundation.border
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

@Composable
fun SquareTable(modifier: Modifier = Modifier) {
    var rowsInput by remember { mutableStateOf("") }
    var colsInput by remember { mutableStateOf("") }

    val rows = rowsInput.toIntOrNull() ?: 0
    val cols = colsInput.toIntOrNull() ?: 0

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
            // Generating dummy/initial state data based on dimensions
            val tableData = remember(rows, cols) {
                List(rows * cols) { index ->
                    MapCell(
                        height = index + 1,
                        cover = when (index % 3) {
                            0 -> "none"
                            1 -> "half"
                            else -> "full"
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
                    TableCell(cell = tableData[index])
                }
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