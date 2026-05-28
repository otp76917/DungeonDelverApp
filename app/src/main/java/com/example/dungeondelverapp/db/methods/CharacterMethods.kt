package com.example.dungeondelverapp.db.methods

import androidx.lifecycle.ViewModel
import com.example.dungeondelverapp.MyApp.Companion.store
import com.example.dungeondelverapp.db.CharacterDB
import com.example.dungeondelverapp.db.CharacterDB_
import com.example.dungeondelverapp.items.CurrentSession
import io.objectbox.Box

class CharacterViewModel : ViewModel() {

    val characterDBBox: Box<CharacterDB> = store.boxFor(CharacterDB::class.java)

    fun add(characterDB: CharacterDB) {
        characterDBBox.put(characterDB)
    }

    fun getById(id: Long): CharacterDB? {
        return characterDBBox.get(id)
    }

    fun getByName(name: String): CharacterDB? {
        return characterDBBox.query(CharacterDB_.name.equal(name)).build().findFirst()
    }

    fun delete(id: Long) {
        characterDBBox.remove(id)
    }

}

fun addCharacter(characterDB: CharacterDB) {
    CharacterViewModel().add(characterDB)
    val characterDBnew = CharacterViewModel().getByName(characterDB.name)!!
    val profile = ProfileViewModel().getById(CurrentSession.user)
    if (profile != null)
    {
        profile.characterDB.add(characterDBnew)
        ProfileViewModel().add(profile)
    }
}

fun getAllCharacters() : List<CharacterDB> {
    val profile = ProfileViewModel().getById(CurrentSession.user)
    return profile?.characterDB?.toList() ?: emptyList()
}