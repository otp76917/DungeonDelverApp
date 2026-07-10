package com.example.dungeondelverapp.views.character.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.db.CharacterDB
import com.example.dungeondelverapp.items.ListViewModel
import com.example.dungeondelverapp.views.TextDisplay
import com.example.dungeondelverapp.views.viewing

@Composable
fun CharacterPage(character: CharacterDB) {
    val mainClass = ListViewModel.listSelector(character.mainClass)
    val subclass = ListViewModel.listSelector(character.subclass)
    val background = ListViewModel.listSelector(character.background)
    val ancestry1 = ListViewModel.listSelector(character.ancestry1)
    val ancestry2 = ListViewModel.listSelector(character.ancestry2)
    val species1 = ListViewModel.listSelector(character.species1)
    val species2 = ListViewModel.listSelector(character.species2)

    val traits = mainClass + subclass + background + ancestry1 + ancestry2 + species1 + species2

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(traits.sortedBy { it.level }.filter { it.level <= character.level }) { trait ->
                TextDisplay(trait)
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { viewing = false },) { Text(text = stringResource(R.string.done)) }
        }
    }

}