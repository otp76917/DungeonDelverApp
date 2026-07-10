package com.example.dungeondelverapp.views.character.data

import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.utils.renderString

fun whichClass(name: String) : List<Int>
{
    return when (name)
    {
        renderString(R.string.artificer) -> artificerOptions
        renderString(R.string.barbarian) -> barbarianOptions
        renderString(R.string.bard) -> bardOptions
        renderString(R.string.bastion) -> bastionOptions

        else -> emptyList()
    }
}