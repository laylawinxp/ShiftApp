package com.laylawinxp.shiftapp.domain.model

data class User(
    val id: String,
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
)