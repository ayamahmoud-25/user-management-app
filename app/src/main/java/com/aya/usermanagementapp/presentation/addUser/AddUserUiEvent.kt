package com.aya.usermanagementapp.presentation.addUser

sealed class AddUserUiEvent {

    data object NavigateToUsers : AddUserUiEvent()

    data class ShowError(
        val message: String
    ) : AddUserUiEvent()
}