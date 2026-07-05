package com.aya.usermanagementapp.presentation.users

import com.aya.usermanagementapp.data.local.entity.UserEntity

data class UsersUiState(
    val users: List<UserEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)