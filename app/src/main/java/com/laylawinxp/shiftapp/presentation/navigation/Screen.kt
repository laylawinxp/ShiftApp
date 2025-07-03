package com.laylawinxp.shiftapp.presentation.navigation

sealed class Screen(val route: String) {
    data object List : Screen("list")
    data object Detail : Screen("detail/{userId}") {
        fun createRoute(userId: String) = "detail/$userId"
    }
}