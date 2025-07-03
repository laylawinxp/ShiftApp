package com.laylawinxp.shiftapp.presentation.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laylawinxp.shiftapp.domain.model.User
import com.laylawinxp.shiftapp.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    var users by mutableStateOf<List<User>>(emptyList())
    var error by mutableStateOf<String?>(null)
    var isRefreshing by mutableStateOf(false)

    init {
        loadUsers()
    }

    fun loadUsers(force: Boolean = false) {
        viewModelScope.launch {
            try {
                isRefreshing = true
                error = null
                users = getUsersUseCase(force)
            } catch (e: Exception) {
                error = "Failed to load users: ${e.localizedMessage}"
            } finally {
                isRefreshing = false
            }
        }
    }
}