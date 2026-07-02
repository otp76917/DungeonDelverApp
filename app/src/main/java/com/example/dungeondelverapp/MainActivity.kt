package com.example.dungeondelverapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.dungeondelverapp.items.ListViewModel
import com.example.dungeondelverapp.ui.theme.DungeonDelverAppTheme
import com.example.dungeondelverapp.views.DualAuthScreen


var logged by mutableStateOf(false)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BackHandler(enabled = true) {
                ListViewModel.goBack()
            }

            DungeonDelverAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (logged) {
                        false -> DualAuthScreen()
                        true -> BottomButtonScreen()
                    }
                }

            }//BottomButtonScreen()
        }
    }
}

