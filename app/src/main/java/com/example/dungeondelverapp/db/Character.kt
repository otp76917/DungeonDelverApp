package com.example.dungeondelverapp.db

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Character(
    @Id var id: Long,
    var name: String,
    var level: Int,
    var mainClass: Int,
    var subclass: Int,
    var background: Int,
    var ancestry1: Int,
    var ancestry2: Int?,
    var species1: Int,
    var species2: Int?,
)