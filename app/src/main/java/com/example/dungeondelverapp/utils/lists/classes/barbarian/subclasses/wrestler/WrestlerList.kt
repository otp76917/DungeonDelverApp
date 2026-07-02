package com.example.dungeondelverapp.utils.lists.classes.barbarian.subclasses.wrestler

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem


val wrestlerHeader = listOf(DashboardItem.Header(MyApp.appContext.getString(R.string.wrestler).uppercase()))

val wrestlerTraitList = listOf(

    DashboardItem.CharacterTrait("Test Trait", "Test Description",0)

)

val wrestlerList = wrestlerHeader + wrestlerTraitList