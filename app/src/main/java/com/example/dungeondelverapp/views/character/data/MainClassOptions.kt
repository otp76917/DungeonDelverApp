package com.example.dungeondelverapp.views.character.data

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R

val mainClassOptions = listOf(
    R.string.artificer,
    R.string.barbarian,
    R.string.bard,
    R.string.bastion
)

fun subClassOptions (string: String) {

    when (string) {
        MyApp.appContext.getString(R.string.artificer) -> listOf(R.string.mechanic)
        MyApp.appContext.getString(R.string.barbarian) -> listOf(R.string.wrestler)
        MyApp.appContext.getString(R.string.bard) -> listOf(R.string.bard)
        MyApp.appContext.getString(R.string.bastion) -> listOf(R.string.bastion)
    }

}