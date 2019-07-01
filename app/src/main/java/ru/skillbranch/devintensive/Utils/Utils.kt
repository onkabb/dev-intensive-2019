package ru.skillbranch.devintensive.Utils

object Utils {

    private val translitMap = mapOf(
        'а' to "a", 'б' to "b", 'в' to "v", 'г' to "g", 'д' to "d", 'е' to "e", 'ё' to "e", 'ж' to "zh", 'з' to "z",
        'и' to "i", 'й' to "i", 'к' to "k", 'л' to "l", 'м' to "m", 'н' to "n", 'о' to "o", 'п' to "p", 'р' to "r",
        'с' to "s", 'т' to "t", 'у' to "u", 'ф' to "f", 'х' to "h", 'ц' to "c", 'ч' to "ch", 'ш' to "sh", 'щ' to "sh",
        'ъ' to "", 'ы' to "i", 'ь' to "", 'э' to "e", 'ю' to "yu", 'я' to "ya"
    )

    fun parseFullName (fullName:String?) : Pair <String?, String?> {

        when (fullName) {
            null, "" -> return "null" to "null"
        }

        var parts: List<String>? =fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        when (firstName) {
            null, "" -> return "null" to "null"
            else -> if (lastName == ""){
                return firstName to "null"
            }
        }

        return firstName to lastName
    }


    fun transliteration(payload: String, divider: String = " ") = buildString {
        payload.forEach {
            append(
                when {
                    it == ' ' -> divider
                    it.isUpperCase() -> translitMap[it.toLowerCase()]?.capitalize() ?: it.toString()
                    else -> translitMap[it] ?: it.toString()
                }
            )
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String? = when {
        firstName.isNullOrBlank() && lastName.isNullOrBlank() -> null
        !firstName.isNullOrBlank() && lastName.isNullOrBlank() -> firstName[0].toUpperCase().toString()
        firstName.isNullOrBlank() && !lastName.isNullOrBlank() -> lastName[0].toUpperCase().toString()
        !firstName.isNullOrBlank() && !lastName.isNullOrBlank() -> firstName[0].toUpperCase() + lastName[0].toUpperCase().toString()
        else -> throw IllegalStateException("Incorrect state in 'when' expression")
    }
}

