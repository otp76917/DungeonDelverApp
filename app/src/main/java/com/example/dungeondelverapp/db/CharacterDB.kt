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
    var mainClass: Int,
    var subclass: Int,
    var background: Int,
    var ancestry1: Int,
    var ancestry2: Int?,
    var species1: Int,
    var species2: Int?,
) {
    lateinit var profile: ToOne<Profile>

    constructor() : this(0, "", 0, 0, 0, 0, 0, null, 0, null)

    constructor(name: String, classId: Int, level: Int) : this(0, name, 0, 0, 0, 0, 0, null, 0, null)


}