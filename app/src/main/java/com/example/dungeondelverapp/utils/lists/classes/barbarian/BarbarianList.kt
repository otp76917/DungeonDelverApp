package com.example.dungeondelverapp.utils.lists.classes.barbarian

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.items.ListViewModel
import com.example.dungeondelverapp.utils.renderString


val barbarianHeader = listOf(DashboardItem.Header(MyApp.appContext.getString(R.string.barbarian).uppercase()))

val barbarianTraitList = listOf(

    DashboardItem.CharacterTrait(renderString(R.string.barbarian_rage_name), renderString(R.string.barbarian_rage_desc), 1),
    DashboardItem.CharacterTrait(renderString(R.string.barbarian_hardskin_name), renderString(R.string.barbarian_hardskin_desc), 1),

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