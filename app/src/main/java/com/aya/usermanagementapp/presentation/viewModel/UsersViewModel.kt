package com.aya.usermanagementapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aya.usermanagementapp.data.repository.UserRepository
import com.aya.usermanagementapp.presentation.users.UsersUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UsersViewModel(
    private val repository: UserRepository
) : ViewModel(){

    private val _uiState = MutableStateFlow(UsersUiState())
    val uiState = _uiState.asStateFlow()


    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            repository.getAllUsers().collect {
                _uiState.value =
                    _uiState.value.copy(users = it)
            }
        }
    }

}