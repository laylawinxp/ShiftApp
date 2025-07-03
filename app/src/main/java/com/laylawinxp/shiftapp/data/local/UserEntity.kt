package com.laylawinxp.shiftapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.laylawinxp.shiftapp.domain.model.User

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val cell: String,
    val age: Int,
    val gender: String,
    val city: String,
    val country: String,
    val timezone: String,
    val address: String,
    val latitude: String,
    val longitude: String,
    val imageUrl: String
) {
    fun toUser() = User(
        id, name, email, phone, cell, age, gender,
        city, country, timezone, address, latitude, longitude, imageUrl
    )

    companion object {
        fun from(user: User) = UserEntity(
            user.id, user.name, user.email, user.phone, user.cell, user.age,
            user.gender, user.city, user.country, user.timezone, user.address,
            user.latitude, user.longitude, user.imageUrl
        )
    }
}