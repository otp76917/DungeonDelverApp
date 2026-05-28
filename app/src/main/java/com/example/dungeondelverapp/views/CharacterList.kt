package com.example.dungeondelverapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.db.CharacterDB
import com.example.dungeondelverapp.db.methods.ProfileViewModel
import com.example.dungeondelverapp.db.methods.addCharacter
import com.example.dungeondelverapp.db.methods.getAllCharacters
import com.example.dungeondelverapp.items.CurrentSession
import com.example.dungeondelverapp.items.ListViewModel


var characterToView by mutableStateOf(CharacterDB())
var creating by mutableStateOf(false)
var viewing by mutableStateOf(false)

@Composable
fun CharacterComponent(profileViewModel: ProfileViewModel = viewModel())
{
    LaunchedEffect(creating, viewing) {
        if (!creating && !viewing) {
            profileViewModel.getAllCharacters(CurrentSession.user)
        }
    }

    if (creating) {
        CharacterCreator()
    }
    else if (viewing) {
        CharacterPage(characterToView)
    }
    else {
        CharacterList(characters = profileViewModel.characterList)
    }
}

@Composable
fun CharacterList(characters: List<CharacterDB>) {

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.weight(1f), // Takes up available space pushing button down
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(characters) { character ->
                CharacterCard(character)
            }
        }
        Button(
            onClick = { creating = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = stringResource(R.string.create_character))
        }
    }

}

@Composable
fun CharacterPage(character: CharacterDB) {
    val mainClass = ListViewModel.listSelector(character.mainClass)
    val subclass = ListViewModel.listSelector(character.subclass)
    val background = ListViewModel.listSelector(character.background)
    val ancestry1 = ListViewModel.listSelector(character.ancestry1)
    //val ancestry2 = ListViewModel.listSelector(character.ancestry2!!)
    val species1 = ListViewModel.listSelector(character.species1)
    //val species2 = ListViewModel.listSelector(character.species2!!)

    val traits = mainClass + subclass + background + ancestry1 + /*ancestry2 +*/ species1 /*+ species2*/

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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
        Button(onClick = { viewing = false }) { Text(text = stringResource(R.string.done)) }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCreator() {

    var expanded by remember { mutableStateOf(false) }
    var nameInput by remember { mutableStateOf("") }

    var selectedMainClass by remember { mutableIntStateOf(0) }

    val mainClassOptions = listOf(R.string.artificer, R.string.barbarian, R.string.bard,R.string.bastion)
    //subclass options for each class

    val backgroundOptions = listOf("TODO")
    val ancestryOptions = listOf("TODO")
    val speciesOptions = listOf("TODO")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nameInput,
            onValueChange = { newValue ->
                nameInput = newValue
            },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier.padding(16.dp)
        ) {
            TextField(
                value = if (selectedMainClass==0) stringResource(id = R.string.classes) else stringResource(id = selectedMainClass),
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                mainClassOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(stringResource(id = option)) },
                        onClick = {
                            selectedMainClass = option
                            expanded = false
                        }
                    )
                }
            }
        }
        Button(onClick = {
            val characterToSave = CharacterDB().apply {
                name = nameInput
                mainClass = selectedMainClass
                level = 1 // Default starting level
                ancestry2 = 0
                species2 = 0
            }
            addCharacter(characterToSave)
            creating = false
        })
        { Text(text = stringResource(R.string.done)) }
    }


}

@Composable
fun CharacterCard(
    character: CharacterDB
) {
    // State to keep track of the counter value
    var count by remember { mutableIntStateOf(character.level) }
    var characterName by remember { mutableStateOf(character.name) }
    var characterClass by remember { mutableIntStateOf(character.mainClass) }

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
                    text = stringResource(id = if (characterClass==0) R.string.classes else characterClass),
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