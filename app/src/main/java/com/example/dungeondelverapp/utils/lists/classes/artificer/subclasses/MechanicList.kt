package com.example.dungeondelverapp.utils.lists.classes.artificer.subclasses

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem

val mechanicHeader = listOf(DashboardItem.Header(MyApp.appContext.getString(R.string.mechanic).uppercase()))

val mechanicTraitList = listOf(

    DashboardItem.CharacterTrait("Test Trait", "Test Description",0)

)

val mechanicList = mechanicHeader + mechanicTraitList