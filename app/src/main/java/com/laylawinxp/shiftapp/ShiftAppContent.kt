package com.laylawinxp.shiftapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.laylawinxp.shiftapp.presentation.navigation.ShiftNavHost
import com.laylawinxp.shiftapp.presentation.theme.ShiftAppTheme
import com.laylawinxp.shiftapp.presentation.theme.ThemeViewModel

@Composable
fun ShiftAppContent(
    themeViewModel: ThemeViewModel = hiltViewModel(),

) {
    val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()

    ShiftAppTheme(darkTheme = isDarkTheme) {
        val navController = rememberNavController()
        ShiftNavHost(
            navController = navController,
            isDarkTheme = isDarkTheme,
            onToggleTheme = { themeViewModel.toggleTheme() }
        )
    }
}