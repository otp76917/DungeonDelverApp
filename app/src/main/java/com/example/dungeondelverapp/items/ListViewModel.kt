package com.example.dungeondelverapp.items

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.db.CharacterDB
import com.example.dungeondelverapp.utils.lists.classes.artificer.artificerList
import com.example.dungeondelverapp.utils.lists.classes.artificer.artificerSubclassList
import com.example.dungeondelverapp.utils.lists.classes.artificer.artificerTraitList
import com.example.dungeondelverapp.utils.lists.classes.artificer.subclasses.mechanicList
import com.example.dungeondelverapp.utils.lists.classes.artificer.subclasses.mechanicTraitList
import com.example.dungeondelverapp.utils.lists.classes.barbarian.barbarianList
import com.example.dungeondelverapp.utils.lists.classes.barbarian.barbarianSubclassList
import com.example.dungeondelverapp.utils.lists.classes.barbarian.barbarianTraitList
import com.example.dungeondelverapp.utils.lists.classes.barbarian.subclasses.wrestlerList
import com.example.dungeondelverapp.utils.lists.classes.barbarian.subclasses.wrestlerTraitList
import com.example.dungeondelverapp.utils.lists.classes.bard.bardList
import com.example.dungeondelverapp.utils.lists.classes.bard.bardTraitList
import com.example.dungeondelverapp.utils.lists.classes.bastion.bastionList
import com.example.dungeondelverapp.utils.lists.classes.bastion.bastionTraitList
import com.example.dungeondelverapp.utils.lists.classes.classesList
import com.example.dungeondelverapp.utils.mainList
import com.example.dungeondelverapp.utils.myDashboardItems
import com.example.dungeondelverapp.views.CharacterCard
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

            //Lists
            R.string.classes -> MainList(classesList)

            //Classes
            R.string.artificer -> MainList(artificerList)
            R.string.barbarian -> MainList(barbarianList)
            R.string.bard -> MainList(bardList)
            R.string.bastion -> MainList(bastionList)

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

            //Error handler
            else -> MainList(myDashboardItems)
        }
    }

    fun listSelector(int: Int) : List<DashboardItem.CharacterTrait>
    {
        when (int) {

            //Classes
            R.string.artificer -> return artificerTraitList
            R.string.barbarian -> return barbarianTraitList
            R.string.bard -> return bardTraitList
            R.string.bastion -> return bastionTraitList

            //Artificer subclasses
            R.string.mechanic -> return mechanicTraitList

            //Barbarian subclasses
            R.string.wrestler -> return wrestlerTraitList

            //Bard subclasses

            //Bastion subclasses


            else -> return emptyList()
        }
    }
}