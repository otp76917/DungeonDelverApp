package com.example.dungeondelverapp.items

import com.example.dungeondelverapp.db.enums.ProfileEnum

object CurrentSession {
    var user = 0
    var profile = ProfileEnum.GUEST
}