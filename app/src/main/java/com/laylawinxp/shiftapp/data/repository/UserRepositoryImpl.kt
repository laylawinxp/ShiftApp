package com.laylawinxp.shiftapp.data.repository

import com.laylawinxp.shiftapp.data.local.UserDao
import com.laylawinxp.shiftapp.data.local.UserEntity
import com.laylawinxp.shiftapp.data.remote.RandomUserApi
import com.laylawinxp.shiftapp.domain.model.User
import com.laylawinxp.shiftapp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: RandomUserApi,
    private val dao: UserDao
) : UserRepository {

    override suspend fun getUsers(forceRefresh: Boolean): List<User> {
        return try {
            if (forceRefresh) {
                val users = api.getUsers().results.map { it.toUser() }
                dao.clearAll()
                dao.insertAll(users.map { UserEntity.from(it) })
                users
            } else {
                val local = dao.getAll()
                if (local.isNotEmpty()) local.map { it.toUser() }
                else {
                    val users = api.getUsers().results.map { it.toUser() }
                    dao.clearAll()
                    dao.insertAll(users.map { UserEntity.from(it) })
                    users
                }
            }
        } catch (e: Exception) {
            val local = dao.getAll().map { it.toUser() }
            if (local.isNotEmpty()) {
                throw Exception("error while loading new data")
            } else {
                throw e
            }
        }
    }

    override suspend fun getUserById(id: String): User? {
        return dao.getAll().find { it.id == id }?.toUser()
    }
}

