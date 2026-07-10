package com.example.dungeondelverapp.utils.lists.ancestries.brute

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.items.ListViewModel

val bruteHeader = listOf(DashboardItem.Header(MyApp.appContext.getString(R.string.brute).uppercase()))

val bruteFullTraitList = listOf(

    DashboardItem.Header(MyApp.appContext.getString(R.string.brute).uppercase()),

)

val bruteHalfTraitList = listOf(

    DashboardItem.Header(MyApp.appContext.getString(R.string.brute).lowercase()),

)


val changeHalf = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString( R.string.half),
        onClick = { ListViewModel.updateCurrentList(R.string.brute-R.string.half) }
    ),

)

val changeFull = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.full),
        onClick = { ListViewModel.updateCurrentList(R.string.brute-R.string.full) }
    ),

)


val speciesButton = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.species),
        onClick = {  }
    ),

)



val bruteFullList = bruteHeader + bruteFullTraitList + changeHalf + speciesButton

val bruteHalfList = bruteHeader + bruteHalfTraitList + changeFull + speciesButton



val bruteSpeciesList = listOf(

    DashboardItem.Header(MyApp.appContext.getString(R.string.species).uppercase()),

    )