package com.aya.usermanagementapp.presentation.users

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.aya.usermanagementapp.presentation.viewModel.UsersViewModel

@Composable
fun UsersScreen(
    viewModel: UsersViewModel
) {

    val uiState = viewModel.uiState.collectAsState().value

    LazyColumn {
        items(uiState.users) { user ->

            Text(
                text = user.name
            )
        }
    }
}