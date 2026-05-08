package com.example.dungeondelverapp.db

import com.example.dungeondelverapp.db.enums.AncestriesEnum
import com.example.dungeondelverapp.db.enums.BackgroundsEnum
import com.example.dungeondelverapp.db.enums.ClassesEnum
import com.example.dungeondelverapp.db.enums.SpeciesEnum
import com.example.dungeondelverapp.db.enums.SubclassesEnum
import io.objectbox.annotation.Entity

@Entity
data class Character(
    var name: String,
    var level: Int,
    var mainClass: ClassesEnum,
    var subclass: SubclassesEnum,
    var background: BackgroundsEnum,
    var ancestry1: AncestriesEnum,
    var ancestry2: AncestriesEnum?,
    var species1: SpeciesEnum,
    var species2: SpeciesEnum?,
)