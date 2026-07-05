package com.aya.usermanagementapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.aya.usermanagementapp.data.local.entity.UserEntity
import com.aya.usermanagementapp.presentation.addUser.AddUserUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import com.aya.usermanagementapp.data.repository.UserRepository
import com.aya.usermanagementapp.presentation.addUser.AddUserUiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class AddUserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddUserUiState())
    val uiState = _uiState.asStateFlow()

   private val _event = MutableSharedFlow<AddUserUiEvent>()
    val event = _event.asSharedFlow()
    fun onNameChange(value: String) {
        _uiState.value = _uiState.value.copy(name = value)
    }

    fun onAgeChange(value: String) {
        _uiState.value = _uiState.value.copy(age = value)
    }

    fun onJobChange(value: String) {
        _uiState.value = _uiState.value.copy(job = value)
    }

    fun onGenderChange(value: String) {
        _uiState.value = _uiState.value.copy(gender = value)
    }

    fun saveUser() {
        viewModelScope.launch {

            if (_uiState.value.name.isBlank()) {
                _event.emit(
                    AddUserUiEvent.ShowError("Name is required")
                )
                return@launch
            }
            if (_uiState.value.age.isBlank()) {
                _event.emit(
                    AddUserUiEvent.ShowError("Age is required")
                )
                return@launch
            }

            if (_uiState.value.job.isBlank()) {
                _event.emit(
                    AddUserUiEvent.ShowError("Job is required")
                )
                return@launch
            }

            if (_uiState.value.gender.isBlank()) {
                _event.emit(
                    AddUserUiEvent.ShowError("Gender is required")
                )
                return@launch
            }

            val age = _uiState.value.age.toIntOrNull()
            if (age == null) {
                _event.emit(
                    AddUserUiEvent.ShowError("Age must be a number")
                )
                return@launch
            }

            val user = UserEntity(
                name = _uiState.value.name,
                age = age,
                jobTitle = _uiState.value.job,
                gender = _uiState.value.gender
            )

            repository.insertUser(user)

            _event.emit(AddUserUiEvent.NavigateToUsers)
        }
    }
}