package com.example.dungeondelverapp.db

import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
data class Profile (
    @Id var id: Long = 0,
    val userName:String,
    val gm:Boolean
) {
    @Backlink(to = "profile")
    lateinit var characterDB: ToMany<CharacterDB>
}
