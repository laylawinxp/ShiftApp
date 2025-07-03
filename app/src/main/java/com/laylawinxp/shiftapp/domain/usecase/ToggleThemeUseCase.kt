package com.laylawinxp.shiftapp.domain.usecase

import com.laylawinxp.shiftapp.data.preferences.ThemePreference
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class ToggleThemeUseCase @Inject constructor(
    private val themePreference: ThemePreference
) {
    suspend operator fun invoke(isDark: Boolean) {
        themePreference.setDarkTheme(isDark)
    }

    suspend fun getCurrentTheme(): Boolean {
        return themePreference.isDarkThemeFlow.first()
    }
}