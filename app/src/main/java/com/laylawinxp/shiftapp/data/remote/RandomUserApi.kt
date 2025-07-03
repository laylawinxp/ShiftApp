package com.laylawinxp.shiftapp.data.remote

import retrofit2.http.GET

interface RandomUserApi {
    @GET("api/?results=20")
    suspend fun getUsers(): UserResponse
}