package com.example.dungeondelverapp.db

import androidx.compose.material3.NavigationBar
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

@Entity
data class CharacterDB(
    @Id var id: Long = 0,
    var name: String,
    var level: Int,
    var mainClass: String,
    var subclass: String,
    var background: String,
    var ancestry1: String,
    var ancestry2: String,
    var species1: String,
    var species2: String,
) {
    lateinit var profile: ToOne<Profile>

    constructor() : this(0, "", 0, "", "", "", "", "", "", "")

    constructor(name: String, mainClass: String, level: Int) : this(0, name, level, mainClass, "", "", "", "", "", "")


}