package com.example.dungeondelverapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                when (logged) {
                    false -> DualAuthScreen()
                    true -> BottomButtonScreen()
                }
            }//BottomButtonScreen()
        }
    }
}

