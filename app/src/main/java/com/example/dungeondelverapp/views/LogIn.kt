package com.example.dungeondelverapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DualAuthScreen() {
    var loginUsername by remember { mutableStateOf("") }
    var registerUsername by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // --- LOGIN SECTION (Top) ---
        LoginSection(
            title = "Login",
            value = loginUsername,
            onValueChange = { loginUsername = it },
            buttonText = "Enter Profile",
            onAction = { /* Logic: Load existing local profile */ }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Visual Separator
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)

        Spacer(modifier = Modifier.height(32.dp))

        // --- REGISTER SECTION (Bottom) ---
        RegisterSection(
            title = "Register",
            value = registerUsername,
            onValueChange = { registerUsername = it },
            buttonText = "Create New Profile",
            onAction = { /* Logic: Save new local profile */ }
        )
    }}
}

@Composable
fun RegisterSection(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    buttonText: String,
    onAction: () -> Unit
) {
    var isChecked by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Game Master")
            Checkbox(
                checked = isChecked,

                onCheckedChange = { newValue ->
                    isChecked = newValue
                }
            )
        }



        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onAction,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(buttonText)
        }
    }
}

@Composable
fun LoginSection(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    buttonText: String,
    onAction: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onAction,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(buttonText)
        }
    }
}