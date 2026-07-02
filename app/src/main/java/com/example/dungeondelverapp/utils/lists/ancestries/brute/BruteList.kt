package com.example.dungeondelverapp.utils.lists.ancestries.brute

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem

val bruteHeader = listOf(DashboardItem.Header(MyApp.appContext.getString(R.string.brute).uppercase()))


val bruteFullList = listOf(

    DashboardItem.Header(MyApp.appContext.getString(R.string.brute).uppercase()),

)

val bruteHalfList = listOf(

    DashboardItem.Header(MyApp.appContext.getString(R.string.brute).lowercase()),

)

val changeHalf = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString( R.string.half),
        onClick = {  }
    ),

)

val changeFull = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.full),
        onClick = {  }
    ),

)


val speciesButton = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.species),
        onClick = {  }
    ),

)

val bruteSpeciesList = listOf(

    DashboardItem.Header(MyApp.appContext.getString(R.string.species).uppercase()),

)