package com.example.dungeondelverapp.db

class MapCell (
    var height: Int,
    var cover: String
) {
    init {
        require(cover in setOf("none", "half", "full")) {
            "Coverage must be 'none', 'half', or 'full'"
        }
    }
}