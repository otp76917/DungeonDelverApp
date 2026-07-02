package com.example.dungeondelverapp.items

sealed class DashboardItem {
    data class Header(val title: String) : DashboardItem()
    data class UserProfile(val name: String, val bio: String) : DashboardItem()
    data class ActionButton(val label: String, val onClick: () -> Unit) : DashboardItem()
    data class CharacterTrait(val name: String, val description: String, val level: Int) : DashboardItem()
    data class SpellOption(val ap: Int, val mp: Int, val tier: Int, val description: String)
    data class Spell(val name: String, val options: List<SpellOption>, val classes: List<Int>) : DashboardItem()
}