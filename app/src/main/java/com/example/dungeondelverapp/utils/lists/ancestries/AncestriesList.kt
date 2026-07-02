package com.example.dungeondelverapp.utils.lists.ancestries

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.items.ListViewModel

val ancestriesList = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.brute),
        onClick = { ListViewModel.updateCurrentList(R.string.brute) }
    ),

)