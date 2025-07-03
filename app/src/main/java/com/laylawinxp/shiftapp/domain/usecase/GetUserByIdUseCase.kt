package com.laylawinxp.shiftapp.domain.usecase

import com.laylawinxp.shiftapp.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(id: String) = repository.getUserById(id)
}