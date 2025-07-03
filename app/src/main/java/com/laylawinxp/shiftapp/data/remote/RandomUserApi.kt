package com.laylawinxp.shiftapp.data.remote

import retrofit2.http.GET

interface RandomUserApi {
    @GET("api/?results=50")
    suspend fun getUsers(): UserResponse
}