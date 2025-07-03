package com.laylawinxp.shiftapp.domain.usecase

import com.laylawinxp.shiftapp.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean = false) = repository.getUsers(forceRefresh)
}