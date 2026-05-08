package com.example.dungeondelverapp.utils.lists.classes.artificer

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.items.ListViewModel

val artificerTraitList = listOf(

    DashboardItem.Header(MyApp.appContext.getString(R.string.artificer).uppercase())

)

val subclassButton = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.subclasses),
        onClick = { ListViewModel.updateCurrentList(R.string.subclasses-R.string.artificer) }
    ),

)

val artificerList = artificerTraitList + subclassButton

val artificerSubclassList = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.mechanic),
        onClick = { ListViewModel.updateCurrentList(R.string.mechanic) }
    ),

)