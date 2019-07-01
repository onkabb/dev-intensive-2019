package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.utils.Utils
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView

fun User.toUserView(): UserView {
    val fullName = "$firstName $lastName"
    val nickname = Utils.transliteration(fullName, "_")
    val initials = Utils.toInitials(firstName, lastName)
    val status = when {
        lastVisit == null -> "Еще ни разу не был"
        isOnline -> "online"
        else -> "Последний раз был ${lastVisit?.humanizeDiff()}"
    }

    return UserView(
        id = id,
        fullName = fullName,
        nickName = nickname,
        initials = initials,
        avatar = avatar,
        status = status
    )
}