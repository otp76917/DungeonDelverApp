package com.example.dungeondelverapp.views.character.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dungeondelverapp.db.CharacterDB
import com.example.dungeondelverapp.db.methods.addCharacter
import com.example.dungeondelverapp.views.characterToView
import com.example.dungeondelverapp.views.viewing

@Composable
fun CharacterCard(
    character: CharacterDB
) {
    // State to keep track of the counter value
    var count by remember { mutableIntStateOf(character.level) }
    var characterName by remember { mutableStateOf(character.name) }
    var characterClass by remember { mutableStateOf(character.mainClass) }

    ElevatedCard(
        onClick = { characterToView = character; viewing = true },
        colors = CardDefaults.cardColors(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Text Content Section
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = characterName,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = characterClass,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Counter Controls Section
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { if (character.level<20) { character.level++; addCharacter(character); count++ }}) {
                    Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Increase")
                }

                Text(
                    text = "$count",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Medium
                )

                IconButton(onClick = { if (character.level>1) { character.level--; addCharacter(character) ; count-- }}) {
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Decrease")
                }
            }
        }
    }
}