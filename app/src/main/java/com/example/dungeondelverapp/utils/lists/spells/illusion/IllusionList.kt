package com.example.dungeondelverapp.utils.lists.spells.illusion

import com.example.dungeondelverapp.MyApp
import com.example.dungeondelverapp.R
import com.example.dungeondelverapp.items.DashboardItem

val spellOptions = listOf(

    DashboardItem.SpellOption(1, 0, 1, "Creas una imagen o un sonido. La imagen debe medir 5 pies o menos. Las criaturas pueden hacer una tirada de percepción para saber que la imagen es falsa. " +
            "Puedes usar otra acción para hacer que se mueva la ilusión hasta 20 pies."),

    DashboardItem.SpellOption(2, 1, 1, "Haces que tú y tu ropa os veais distinto. No afecta a tu estatura. (Tirada de percepción)"),

    DashboardItem.SpellOption(1, 2, 1, "En un área de 20 pies de radio (hasta 60 pies de distancia), haces una nube de un color a elección. Las criaturas que no sepan que es una ilisión reciben 1d4 de daño psíquico.")


)

val illusionSpell = DashboardItem.Spell(

    MyApp.appContext.getString(R.string.illusion),
    spellOptions,
    listOf(R.string.bastion)

)