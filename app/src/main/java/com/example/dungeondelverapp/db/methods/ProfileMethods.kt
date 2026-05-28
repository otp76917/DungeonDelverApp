package com.example.dungeondelverapp.db.methods

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dungeondelverapp.MyApp.Companion.appContext
import com.example.dungeondelverapp.MyApp.Companion.store
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.db.CharacterDB
import com.example.dungeondelverapp.db.Profile
import com.example.dungeondelverapp.db.Profile_
import com.example.dungeondelverapp.items.CurrentSession
import com.example.dungeondelverapp.logged
import com.example.dungeondelverapp.views.ProfileView
import io.objectbox.Box



class ProfileViewModel : ViewModel() {

    val profileBox: Box<Profile> = store.boxFor(Profile::class.java)

    fun add(profile: Profile) {
        profileBox.put(profile)
    }

    fun getById(id: Long): Profile? {
        return profileBox.get(id)
    }

    fun getByName(name: String): Profile? {
        return profileBox.query(Profile_.userName.equal(name)).build().findFirst()
    }

    fun delete(id: Long) {
        profileBox.remove(id)
    }

    companion object

    var characterList by mutableStateOf<List<CharacterDB>>(emptyList())
        private set

    fun getAllCharacters(userId: Long) {
        val profile = getById(userId)
        characterList = profile?.characterDB?.toList() ?: emptyList()
    }

}


fun loginMethod(name: String)
{
    val profile = ProfileViewModel().getByName(name)

    if (profile != null)
    {
        CurrentSession.user = profile.id
        CurrentSession.gm = profile.gm
        logged = true
    }
    else Toast.makeText(appContext, appContext.getString(R.string.user_not_found), Toast.LENGTH_SHORT).show()
}

fun registerMethod(name: String, gm: Boolean)
{
    var profile = ProfileViewModel().getByName(name)

    if (profile == null)
    {

        ProfileViewModel().add(Profile(0,name,gm))
        profile = ProfileViewModel().getByName(name)
        if (profile != null) CurrentSession.user = profile.id
        if (profile != null) CurrentSession.gm = profile.gm
        logged = true
    }
    else Toast.makeText(appContext, appContext.getString(R.string.user_exists), Toast.LENGTH_SHORT).show()
}
