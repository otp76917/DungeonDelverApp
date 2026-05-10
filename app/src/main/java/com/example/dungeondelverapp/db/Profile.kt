package com.example.dungeondelverapp.db

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Profile (
    @Id var id: Long,
    val userName:String,
    val gm:Boolean
)