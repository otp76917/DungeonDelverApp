package com.example.dungeondelverapp.views.character.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.db.CharacterDB
import com.example.dungeondelverapp.db.methods.addCharacter
import com.example.dungeondelverapp.views.character.data.mainClassOptions
import com.example.dungeondelverapp.views.character.data.whichClass
import com.example.dungeondelverapp.views.character.ui.creator.CharacterDropDownMenu
import com.example.dungeondelverapp.views.creating

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCreator() {

    var nameInput by remember { mutableStateOf("") }

    var selectedMainClass by remember { mutableStateOf("") }
    var selectedSubclass by remember { mutableStateOf("") }
    var selectedBackground by remember { mutableStateOf("") }
    var selectedAncestry1 by remember { mutableStateOf("") }
    var selectedAncestry2 by remember { mutableStateOf("") }
    var selectedSpecies1 by remember { mutableStateOf("") }
    var selectedSpecies2 by remember { mutableStateOf("") }

    val subclassOptions by remember {
        derivedStateOf { whichClass(selectedMainClass) }
    }


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
            //modifier = Modifier.fillMaxWidth()
        )

        CharacterDropDownMenu(
            identifier = R.string.classes,
            list = mainClassOptions,
            selectedOption = selectedMainClass,
            onValueChange = { newClass ->
                selectedMainClass = newClass
                selectedSubclass = ""
            }
        )

        CharacterDropDownMenu(
            identifier = R.string.subclasses,
            list = subclassOptions,
            selectedOption = selectedSubclass,
            onValueChange = { newSubclass ->
                selectedSubclass = newSubclass
            }
        )

        /*

        Row(verticalAlignment = Alignment.CenterVertically) {

            CharacterDropDownMenu(
                identifier =  R.string.subclasses,
                list = subclassOptions,
                selectedOption = selectedSubclass,
                onValueChange = { newSubclass ->
                    selectedSubclass = newSubclass
                }
            )

            IconButton(onClick = { selectedSubclass = "" },
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Red)) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete",
                    tint = Color.White
                )
            }

        }

        */



        Row() {
            Button(onClick = {
                val characterToSave = CharacterDB().apply {
                    name = nameInput
                    mainClass = selectedMainClass
                    subclass = selectedSubclass
                    background = selectedBackground
                    level = 1 // Default starting level
                    ancestry1 = selectedAncestry1
                    species1 = selectedSpecies1
                }
                addCharacter(characterToSave)
                creating = false
            })
            { Text(text = stringResource(R.string.done)) }

            Button(
                onClick = { creating = false },
                colors = ButtonDefaults.buttonColors(Color.Red, Color.White)
            )
            { Text(text = stringResource(R.string.cancel)) }
        }
    }
}