package com.example.dungeondelverapp.utils.lists.spells.curse

import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.utils.renderString

val spellOptions = listOf(

    DashboardItem.SpellOption(1, 0, 1, "Test Description")

)

val curseSpell = DashboardItem.Spell(

    name = renderString(R.string.curse),
    options = spellOptions,
    listOf()

)