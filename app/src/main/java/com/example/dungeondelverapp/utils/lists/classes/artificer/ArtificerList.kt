package com.example.dungeondelverapp.utils.lists.classes.artificer

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.items.ListViewModel
import com.example.dungeondelverapp.utils.renderString


val artificerHeader = listOf(DashboardItem.Header(MyApp.appContext.getString(R.string.artificer).uppercase()))

val artificerTraitList = listOf(

    DashboardItem.CharacterTrait(renderString(R.string.artificer_craftsman_name), renderString(R.string.artificer_craftsman_desc), 1),
    DashboardItem.CharacterTrait(renderString(R.string.artificer_combatsmith_name), renderString(R.string.artificer_combatsmith_desc), 1),

)

val subclassButton = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.subclasses),
        onClick = { ListViewModel.updateCurrentList(R.string.subclasses-R.string.artificer) }
    ),

)

val artificerList = artificerHeader + artificerTraitList + subclassButton

val artificerSubclassList = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.mechanic),
        onClick = { ListViewModel.updateCurrentList(R.string.mechanic) }
    ),

)