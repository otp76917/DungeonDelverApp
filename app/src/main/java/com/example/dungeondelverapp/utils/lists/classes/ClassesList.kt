package com.example.dungeondelverapp.utils.lists.classes

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.items.ListViewModel

val classesList = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.artificer),
        onClick = { ListViewModel.updateCurrentList(R.string.artificer) }
    ),

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.barbarian),
        onClick = { ListViewModel.updateCurrentList(R.string.barbarian) }
    ),

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.bard),
        onClick = { ListViewModel.updateCurrentList(R.string.bard) }
    ),

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.bastion),
        onClick = { ListViewModel.updateCurrentList(R.string.bastion) }
    ),

)