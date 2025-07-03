package com.laylawinxp.shiftapp.domain.usecase

import com.laylawinxp.shiftapp.domain.model.User
import javax.inject.Inject

class ShareUserUseCase @Inject constructor() {
    operator fun invoke(user: User): String {
        return "${user.name}\n${user.email}\n${user.cell}\n${user.phone}\n" +
                "${user.gender}\nage ${user.age}\n${user.address}"
    }
}