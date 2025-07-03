package com.laylawinxp.shiftapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.laylawinxp.shiftapp.presentation.users.UserDetailScreen
import com.laylawinxp.shiftapp.presentation.users.UserListScreen

@Composable
fun ShiftNavHost(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.List.route
    ) {
        composable(Screen.List.route) {
            UserListScreen(
                onUserClick = { user ->
                    navController.navigate(Screen.Detail.createRoute(user.id))
                },
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme
            )
        }
        composable(Screen.Detail.route) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: return@composable
            UserDetailScreen(
                userId = userId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}