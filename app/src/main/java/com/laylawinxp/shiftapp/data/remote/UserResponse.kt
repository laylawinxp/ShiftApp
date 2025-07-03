package com.laylawinxp.shiftapp.data.remote

import com.laylawinxp.shiftapp.domain.model.User

data class UserResponse(val results: List<UserDto>)

data class UserDto(
    val login: Login,
    val name: Name,
    val email: String,
    val phone: String,
    val cell: String,
    val dob: Dob,
    val gender: String,
    val location: Location,
    val picture: Picture
) {
    fun toUser(): User {
        return User(
            id = login.uuid,
            name = "${name.first} ${name.last}",
            email = email,
            phone = phone,
            cell = cell,
            age = dob.age,
            gender = gender,
            city = location.city,
            country = location.country,
            timezone = location.timezone.description,
            address = "${location.street.name} ${location.street.number}, ${location.city}, ${location.country}",
            latitude = location.coordinates.latitude,
            longitude = location.coordinates.longitude,
            imageUrl = picture.large
        )
    }
}

data class Login(val uuid: String)
data class Name(val first: String, val last: String)
data class Dob(val age: Int)
data class Picture(val large: String)

data class Location(
    val street: Street,
    val city: String,
    val country: String,
    val timezone: Timezone,
    val coordinates: Coordinates
)

data class Street(val number: Int, val name: String)
data class Coordinates(val latitude: String, val longitude: String)
data class Timezone(val description: String)