package com.example.dungeondelverapp.utils.lists.classes.bastion

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.items.ListViewModel
import com.example.dungeondelverapp.utils.renderString


val bastionHeader = listOf(DashboardItem.Header(MyApp.appContext.getString(R.string.bastion).uppercase()))

val bastionTraitList = listOf(

    DashboardItem.CharacterTrait(renderString(R.string.bastion_sacrifice_name), renderString(R.string.bastion_sacrifice_desc),1),

)

val subclassButton = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.subclasses),
        onClick = { ListViewModel.updateCurrentList(R.string.subclasses-R.string.bastion) }
    ),

)

val bastionList = bastionHeader + bastionTraitList + subclassButton