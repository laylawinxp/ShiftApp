package com.laylawinxp.shiftapp.domain.repository

import com.laylawinxp.shiftapp.domain.model.User

interface UserRepository {
    suspend fun getUsers(forceRefresh: Boolean): List<User>
    suspend fun getUserById(id: String): User?
}