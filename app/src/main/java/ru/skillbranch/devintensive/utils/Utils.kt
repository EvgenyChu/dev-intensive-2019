package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return Pair(firstName, lastName)
    }
    fun String.invertCase(): String {
        val array = this.toCharArray()
        this.forEachIndexed { index, char ->
            when {
                char.isUpperCase() -> array[index] = char.toLowerCase()
            }
        }
        return String(array)
    }

    fun transliteration(fullName: String?) =
        fullName?.invertCase()
            ?.replace(Regex("[абвгдеёжзийклмнопрстуфхцчшщъыьэюя]")) {
                when (it.value) {
                    "а" -> "a"
                    "б" -> "b"
                    "в" -> "v"
                    "г" -> "g"
                    "д" -> "d"
                    "е" -> "e"
                    "ё" -> "e"
                    "ж" -> "zh"
                    "з" -> "z"
                    "и" -> "i"
                    "й" -> "i"
                    "к" -> "k"
                    "л" -> "l"
                    "м" -> "m"
                    "н" -> "n"
                    "о" -> "o"
                    "п" -> "p"
                    "р" -> "r"
                    "с" -> "s"
                    "т" -> "t"
                    "у" -> "u"
                    "ф" -> "f"
                    "х" -> "h"
                    "ц" -> "c"
                    "ч" -> "ch"
                    "ш" -> "sh"
                    "щ" -> "sh"
                    "ъ" -> ""
                    "ы" -> "i"
                    "ь" -> ""
                    "э" -> "e"
                    "ю" -> "yu"
                    "я" -> "ya"
                    else -> it.value
                }
            }

    fun toInitials(firstName: String, lastName: String): String {
        val stringA = firstName.first().uppercase()
        val stringB = lastName.first().uppercase()
        val stringC = " "
        val initials = stringA +stringC + stringB
        return initials
    }
}

