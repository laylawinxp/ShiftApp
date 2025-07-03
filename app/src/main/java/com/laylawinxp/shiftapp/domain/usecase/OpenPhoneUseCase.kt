package com.laylawinxp.shiftapp.domain.usecase

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.laylawinxp.shiftapp.presentation.users.safeStartActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class OpenPhoneUseCase @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun getIntent(phoneNumber: String): Intent {
        return Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
    }

    operator fun invoke(phoneNumber: String) {
        safeStartActivity(context, getIntent(phoneNumber))
    }
}