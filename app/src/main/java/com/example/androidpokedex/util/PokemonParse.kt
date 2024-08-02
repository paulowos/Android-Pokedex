package com.example.androidpokedex.util

import androidx.compose.ui.graphics.Color
import com.example.androidpokedex.data.network.responses.Pokemon
import com.example.androidpokedex.ui.theme.AtkColor
import com.example.androidpokedex.ui.theme.DefColor
import com.example.androidpokedex.ui.theme.HPColor
import com.example.androidpokedex.ui.theme.SpAtkColor
import com.example.androidpokedex.ui.theme.SpDefColor
import com.example.androidpokedex.ui.theme.SpdColor
import com.example.androidpokedex.ui.theme.TypeBug
import com.example.androidpokedex.ui.theme.TypeDark
import com.example.androidpokedex.ui.theme.TypeDragon
import com.example.androidpokedex.ui.theme.TypeElectric
import com.example.androidpokedex.ui.theme.TypeFairy
import com.example.androidpokedex.ui.theme.TypeFighting
import com.example.androidpokedex.ui.theme.TypeFire
import com.example.androidpokedex.ui.theme.TypeFlying
import com.example.androidpokedex.ui.theme.TypeGhost
import com.example.androidpokedex.ui.theme.TypeGrass
import com.example.androidpokedex.ui.theme.TypeGround
import com.example.androidpokedex.ui.theme.TypeIce
import com.example.androidpokedex.ui.theme.TypeNormal
import com.example.androidpokedex.ui.theme.TypePoison
import com.example.androidpokedex.ui.theme.TypePsychic
import com.example.androidpokedex.ui.theme.TypeRock
import com.example.androidpokedex.ui.theme.TypeSteel
import com.example.androidpokedex.ui.theme.TypeWater
import java.util.Locale

object PokemonParse {
    fun typeToColor(type: Pokemon.Type): Color {
        return when (type.type.name.lowercase(Locale.ROOT)) {
            "normal" -> TypeNormal
            "fire" -> TypeFire
            "water" -> TypeWater
            "electric" -> TypeElectric
            "grass" -> TypeGrass
            "ice" -> TypeIce
            "fighting" -> TypeFighting
            "poison" -> TypePoison
            "ground" -> TypeGround
            "flying" -> TypeFlying
            "psychic" -> TypePsychic
            "bug" -> TypeBug
            "rock" -> TypeRock
            "ghost" -> TypeGhost
            "dragon" -> TypeDragon
            "dark" -> TypeDark
            "steel" -> TypeSteel
            "fairy" -> TypeFairy
            else -> Color.Black
        }
    }

    fun statToColor(stat: Pokemon.Stat): Color {
        return when (stat.stat.name.lowercase(Locale.ROOT)) {
            "hp" -> HPColor
            "attack" -> AtkColor
            "defense" -> DefColor
            "special-attack" -> SpAtkColor
            "special-defense" -> SpDefColor
            "speed" -> SpdColor
            else -> Color.White
        }
    }

    fun statToAbbr(stat: Pokemon.Stat): String {
        return when (stat.stat.name.lowercase(Locale.ROOT)) {
            "hp" -> "HP"
            "attack" -> "Atk"
            "defense" -> "Def"
            "special-attack" -> "SpAtk"
            "special-defense" -> "SpDef"
            "speed" -> "Spd"
            else -> ""
        }
    }
}