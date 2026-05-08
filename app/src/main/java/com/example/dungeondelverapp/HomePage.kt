package com.example.dungeondelverapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.dungeondelverapp.items.ListViewModel

@Composable
fun BottomButtonScreen() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            // Row is used to place items horizontally
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    // Adjusting height to roughly 8% of a standard screen
                    .height(70.dp)
            ) {
                Button(
                    onClick = { ListViewModel.updateCurrentList(0) },
                    // weight(1f) ensures it takes exactly half the Row's width
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    shape = RectangleShape // Makes the button rectangular
                ) {
                    Text(stringResource(id = R.string.listsButton))
                }

                Button(
                    onClick = { ListViewModel.updateCurrentList(1) },
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    shape = RectangleShape,
                    // Different color to distinguish them
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Text("Button 2")
                }
            }
        }
    ) { innerPadding ->
        // Main content goes here
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            ListViewModel.ListDisplay()

        //ItemList(myDashboardItems)
        }
    }
}