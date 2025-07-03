package com.laylawinxp.shiftapp.domain.usecase

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.laylawinxp.shiftapp.presentation.users.safeStartActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class OpenEmailUseCase @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun getIntent(email: String): Intent {
        return Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
        }
    }

    operator fun invoke(email: String) {
        safeStartActivity(context, getIntent(email))
    }
}