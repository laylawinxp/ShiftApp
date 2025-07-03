package com.laylawinxp.shiftapp.domain.usecase

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.laylawinxp.shiftapp.presentation.users.safeStartActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class OpenMapUseCase @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun getAddressIntent(address: String): Intent {
        return Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("geo:0,0?q=${Uri.encode(address)}")
        }
    }

    fun getCoordinatesIntent(lat: String, lon: String, label: String): Intent {
        val geoUri = "geo:$lat,$lon?q=$lat,$lon(${Uri.encode(label)})"
        return Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
    }

    operator fun invoke(address: String) {
        safeStartActivity(context, getAddressIntent(address))
    }

    operator fun invoke(lat: String, lon: String, label: String) {
        safeStartActivity(context, getCoordinatesIntent(lat, lon, label))
    }
}