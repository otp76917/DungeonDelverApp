package com.example.dungeondelverapp.items

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.maps.allMaps
import com.example.dungeondelverapp.utils.lists.ancestries.ancestriesList
import com.example.dungeondelverapp.utils.lists.classes.artificer.artificerList
import com.example.dungeondelverapp.utils.lists.classes.artificer.artificerSubclassList
import com.example.dungeondelverapp.utils.lists.classes.artificer.artificerTraitList
import com.example.dungeondelverapp.utils.lists.classes.artificer.subclasses.mechanic.mechanicList
import com.example.dungeondelverapp.utils.lists.classes.artificer.subclasses.mechanic.mechanicTraitList
import com.example.dungeondelverapp.utils.lists.classes.barbarian.barbarianList
import com.example.dungeondelverapp.utils.lists.classes.barbarian.barbarianSubclassList
import com.example.dungeondelverapp.utils.lists.classes.barbarian.barbarianTraitList
import com.example.dungeondelverapp.utils.lists.classes.barbarian.subclasses.wrestler.wrestlerList
import com.example.dungeondelverapp.utils.lists.classes.barbarian.subclasses.wrestler.wrestlerTraitList
import com.example.dungeondelverapp.utils.lists.classes.bard.bardList
import com.example.dungeondelverapp.utils.lists.classes.bard.bardTraitList
import com.example.dungeondelverapp.utils.lists.classes.bastion.bastionList
import com.example.dungeondelverapp.utils.lists.classes.bastion.bastionTraitList
import com.example.dungeondelverapp.utils.lists.classes.classesList
import com.example.dungeondelverapp.utils.mainList
import com.example.dungeondelverapp.views.CharacterComponent
import com.example.dungeondelverapp.views.MainList
import com.example.dungeondelverapp.views.SquareTable

object ListViewModel : ViewModel() {

    var currentList by mutableIntStateOf(0)
        private set

    var screenList = mutableListOf(0)



    fun updateCurrentList(newList: Int){ if (newList != currentList) {
        currentList = newList
        screenList.add(currentList)
    }}

    fun goBack() {
        if (screenList.size > 1) {
            screenList.removeAt(screenList.lastIndex)
            currentList = screenList.last()
        }
    }

    @Composable
    fun ListDisplay()
    {
        when (currentList) {

            //Main screen
            0 -> MainList(mainList)

            //User screen
            1 -> {
                if (CurrentSession.gm)
                    SquareTable()
                else
                    CharacterComponent()
            }

            //Artificer subclasses
            (R.string.subclasses-R.string.artificer) -> MainList(artificerSubclassList)
            R.string.mechanic -> MainList(mechanicList)

            //Barbarian subclasses
            (R.string.subclasses-R.string.barbarian) -> MainList(barbarianSubclassList)
            R.string.wrestler -> MainList(wrestlerList)

            //Bard subclasses
            (R.string.subclasses-R.string.bard) -> MainList(bardList)

            //Bastion subclasses
            (R.string.subclasses-R.string.bastion) -> MainList(bastionList)

            else -> {
                val targetedList = allMaps[currentList]
                if (targetedList != null) {
                    MainList(targetedList)
                }
                else {
                    MainList(mainList)
                }
            }
        }
    }

    fun listSelector(string: String) : List<DashboardItem.CharacterTrait>
    {
        when (string) {

            //Classes
            MyApp.appContext.getString(R.string.artificer) -> return artificerTraitList
            MyApp.appContext.getString(R.string.barbarian) -> return barbarianTraitList
            MyApp.appContext.getString(R.string.bard) -> return bardTraitList
            MyApp.appContext.getString(R.string.bastion) -> return bastionTraitList

            //Artificer subclasses
            MyApp.appContext.getString(R.string.mechanic) -> return mechanicTraitList

            //Barbarian subclasses
            MyApp.appContext.getString(R.string.wrestler) -> return wrestlerTraitList

            //Bard subclasses

            //Bastion subclasses


            else -> return emptyList()
        }
    }
}