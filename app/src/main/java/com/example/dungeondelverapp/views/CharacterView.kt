package com.example.dungeondelverapp.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dungeondelverapp.db.CharacterDB
import com.example.dungeondelverapp.db.methods.ProfileViewModel
import com.example.dungeondelverapp.items.CurrentSession
import com.example.dungeondelverapp.views.character.ui.CharacterCreator
import com.example.dungeondelverapp.views.character.ui.CharacterList
import com.example.dungeondelverapp.views.character.ui.CharacterPage


var characterToView by mutableStateOf(CharacterDB())
var creating by mutableStateOf(false)
var viewing by mutableStateOf(false)

@Composable
fun reset(profileViewModel: ProfileViewModel = viewModel()) : ProfileViewModel
{
    LaunchedEffect(creating, viewing) {
        if (!creating && !viewing) {
            profileViewModel.getAllCharacters(CurrentSession.user)
        }
    }
    return profileViewModel
}

@Composable
fun CharacterComponent()
{
    reset()

    if (creating) {
        CharacterCreator()
    }
    else if (viewing) {
        CharacterPage(characterToView)
    }
    else {
        CharacterList(characters = reset().characterList)
    }
}
