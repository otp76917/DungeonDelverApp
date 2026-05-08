package com.example.dungeondelverapp.items

sealed class DashboardItem {
    data class Header(val title: String) : DashboardItem()
    data class UserProfile(val name: String, val bio: String) : DashboardItem()
    data class ActionButton(val label: String, val onClick: () -> Unit) : DashboardItem()
    data class CharacterTrait(val name: String, val description: String, val level: Int) : DashboardItem()
}