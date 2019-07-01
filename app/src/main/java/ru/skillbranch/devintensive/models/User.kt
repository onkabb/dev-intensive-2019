package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {

    val introBit: String

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "Jonny", "Doe")

    init {
        introBit = getIntro()
        println("WAKE THE FUCK UP SAMURAI\n" +
                "${if (lastName == "Doe") "My name is $firstName $lastName" else "And my name is $firstName $lastName!!! "}" +
                "${getIntro()}")
    }

    private fun getIntro(): String = """
        tu tu ru tuuuu!!!
    """.trimIndent()

    fun printMe(): Unit = println(
        """
                id : $id
                firstName : $firstName
                lastName : $lastName
                avatar : $avatar
                rating : $rating
                respect : $respect
                lastVisit : $lastVisit
                isOnline : $isOnline
        """.trimIndent()
    )

    companion object Factory {
        private var lastId : Int = -1
        fun makeUser(fullName:String?): User {
            lastId++
            var (firstName, lastName) = Utils.parseFullName(fullName)
            return User(
                id = "$lastId",
                firstName = firstName,
                lastName = lastName
            )
        }
    }

    class Builder() {
        private var id: String? = null
        private var firstName: String? = null
        private var lastName: String? = null
        private var avatar: String? = null
        private var rating: Int = 0
        private var respect: Int = 0
        private var lastVisit: Date? = null
        private var isOnline: Boolean = false

        fun id(value: String) {
            id = value
        }

        fun firstName(value: String) {
            firstName = value
        }

        fun lastName(value: String) {
            lastName = value
        }

        fun avatar(value: String) {
            avatar = value
        }

        fun rating(value: Int) {
            rating = value
        }

        fun respect(value: Int) {
            respect = value
        }

        fun lastVisit(value: Date) {
            lastVisit = value
        }

        fun isOnline(value: Boolean) {
            isOnline = value
        }

        fun build() = User(
            id ?: (++lastId).toString(),
            firstName,
            lastName,
            avatar,
            rating,
            respect,
            lastVisit,
            isOnline
        )
    }
}



