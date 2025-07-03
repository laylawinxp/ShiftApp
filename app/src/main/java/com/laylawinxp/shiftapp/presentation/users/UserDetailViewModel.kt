package com.laylawinxp.shiftapp.presentation.users

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.laylawinxp.shiftapp.domain.model.User
import com.laylawinxp.shiftapp.domain.usecase.GetUserByIdUseCase
import com.laylawinxp.shiftapp.domain.usecase.OpenEmailUseCase
import com.laylawinxp.shiftapp.domain.usecase.OpenMapUseCase
import com.laylawinxp.shiftapp.domain.usecase.OpenPhoneUseCase
import com.laylawinxp.shiftapp.domain.usecase.ShareUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val shareUserUseCase: ShareUserUseCase,
    private val openEmailUseCase: OpenEmailUseCase,
    private val openPhoneUseCase: OpenPhoneUseCase,
    private val openMapUseCase: OpenMapUseCase
) : ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    suspend fun loadUser(userId: String) {
        user = getUserByIdUseCase(userId)
    }

    fun shareUser(context: Context) {
        user?.let {
            val shareText = shareUserUseCase(it)
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            context.startActivity(Intent.createChooser(intent, "Share via"))
        }
    }

    fun openEmail(context: Context) = user?.email?.let {
        safeStartActivity(context, openEmailUseCase.getIntent(it))
    }

    fun openPhone(context: Context, phone: String) {
        safeStartActivity(context, openPhoneUseCase.getIntent(phone))
    }

    fun openMapByAddress(context: Context) = user?.address?.let {
        safeStartActivity(context, openMapUseCase.getAddressIntent(it))
    }

    fun openMapByCoords(context: Context) {
        user?.let {
            safeStartActivity(
                context,
                openMapUseCase.getCoordinatesIntent(it.latitude, it.longitude, it.name)
            )
        }
    }
}