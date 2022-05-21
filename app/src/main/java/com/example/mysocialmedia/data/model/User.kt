package com.example.mysocialmedia.data.model

data class User(
    val userId: Int
)

fun Int.idToName(): String {
   return when(this) {
        1 -> "Prof Dr Canıtın"
        2 -> "Prof Dr Deniz"
        3 -> "Prof Dr Mustafa"
        4 -> "Prof Dr Melek"
        5 -> "Prof Dr Ayşe"
        6 -> "Prof Dr Metin"
        7 -> "Prof Dr Zeynep"
        8 -> "Prof Dr Uğur"
        9 -> "Prof Dr Volkan"
        10 -> "Prof Dr Fatma"
       else -> ""
   }
}

