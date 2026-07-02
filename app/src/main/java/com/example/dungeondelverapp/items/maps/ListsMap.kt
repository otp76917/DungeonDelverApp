package com.example.dungeondelverapp.items.maps

import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.maps.ancestries.ancestriesMap
import com.example.dungeondelverapp.items.maps.classes.classesMap
import com.example.dungeondelverapp.utils.lists.ancestries.ancestriesList
import com.example.dungeondelverapp.utils.lists.classes.classesList
import com.example.dungeondelverapp.utils.lists.spells.spellsList

val listsMap = mapOf(
    R.string.classes to classesList,
    R.string.ancestries to ancestriesList,
    R.string.spells to spellsList,
)

val allMaps = listsMap + classesMap + ancestriesMap