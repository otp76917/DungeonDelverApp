package com.example.dungeondelverapp.utils.lists.classes.bard

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.items.ListViewModel

val bardTraitList = listOf(

    DashboardItem.Header(MyApp.appContext.getString(R.string.bard).uppercase())

)

val subclassButton = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.subclasses),
        onClick = { ListViewModel.updateCurrentList(R.string.subclasses-R.string.bard) }
    ),

    )

val bardList = bardTraitList + subclassButton