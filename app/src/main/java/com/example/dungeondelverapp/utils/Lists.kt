package com.example.dungeondelverapp.utils

import androidx.compose.ui.res.stringResource
import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem
import com.example.dungeondelverapp.items.ListViewModel

val myDashboardItems = listOf(
    // 1. A Header
    DashboardItem.Header(title = "Account Overview"),

    // 2. A User Profile
    DashboardItem.UserProfile(
        name = "Alex Rivers",
        bio = "Android Developer & UI Enthusiast"
    ),

    // 3. Another Header for a new section
    DashboardItem.Header(title = "Quick Actions"),

    // 4. An Action Button
    DashboardItem.ActionButton(
        label = "Edit Profile",
        onClick = { println("Navigating to Edit...") }
    ),

    // 5. A second Action Button
    DashboardItem.ActionButton(
        label = "Logout",
        onClick = { println("Logging out...") }
    )
)

val mainList = listOf(

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.classes),
        onClick = { ListViewModel.updateCurrentList(R.string.classes) }
    ),

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.ancestries),
        onClick = { ListViewModel.updateCurrentList(R.string.ancestries) }
    ),

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.backgrounds),
        onClick = { ListViewModel.updateCurrentList(R.string.backgrounds) }
    ),

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.items),
        onClick = { ListViewModel.updateCurrentList(R.string.items) }
    ),

    DashboardItem.ActionButton(
        label = MyApp.appContext.getString(R.string.spells),
        onClick = { ListViewModel.updateCurrentList(R.string.spells) }
    ),

)

fun renderString(id: Int): String {
    return MyApp.appContext.getString(id)
}

fun reloadList() {
    ListViewModel.updateCurrentList(ListViewModel.currentList)
}