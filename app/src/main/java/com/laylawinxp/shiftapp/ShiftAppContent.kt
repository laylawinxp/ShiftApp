package com.laylawinxp.shiftapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.laylawinxp.shiftapp.presentation.navigation.ShiftNavHost
import com.laylawinxp.shiftapp.presentation.theme.ShiftAppTheme
import com.laylawinxp.shiftapp.presentation.theme.ThemeViewModel

@Composable
fun ShiftAppContent(
    themeViewModel: ThemeViewModel = hiltViewModel()
) {
    val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()

    if (isDarkTheme == null) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logo_shift_users),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(240.dp),
                    tint = Color.Unspecified
                )
            }
        }
    } else {
        ShiftAppTheme(darkTheme = isDarkTheme!!) {
            val navController = rememberNavController()
            ShiftNavHost(
                navController = navController,
                isDarkTheme = isDarkTheme!!,
                onToggleTheme = { themeViewModel.toggleTheme() }
            )
        }
    }
}