package com.example.dungeondelverapp.utils.lists.classes.barbarian

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.items.ListViewModel


val barbarianHeader = listOf(DashboardItem.Header(MyApp.appContext.getString(R.string.barbarian).uppercase()))

val barbarianTraitList = listOf(

    DashboardItem.CharacterTrait("Hit Die", "12", 0),
    DashboardItem.CharacterTrait("Speed", "30", 0)

)

val subclassButton = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.subclasses),
        onClick = { ListViewModel.updateCurrentList(R.string.subclasses-R.string.barbarian) }
    ),

)

val barbarianList = barbarianHeader + barbarianTraitList + subclassButton

val barbarianSubclassList = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.wrestler),
        onClick = { ListViewModel.updateCurrentList(R.string.wrestler) }
    ),

)