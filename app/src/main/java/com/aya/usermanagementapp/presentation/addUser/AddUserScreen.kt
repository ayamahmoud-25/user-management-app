package com.aya.usermanagementapp.presentation.addUser

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.aya.usermanagementapp.presentation.viewModel.AddUserViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.SnackbarHost
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
@Composable
fun AddUserScreen(
    viewModel: AddUserViewModel,
    onNavigateToUsers: () -> Unit

) {
    val state = viewModel.uiState.collectAsState().value

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->

            when (event) {

                AddUserUiEvent.NavigateToUsers -> {
                    // navigate
                    onNavigateToUsers()
                }

                is AddUserUiEvent.ShowError -> {
                    snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.name,
            onValueChange = {
                viewModel.onNameChange(it)
            },
            label = { Text("Name") }
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.age,
            onValueChange = {
                viewModel.onAgeChange(it)
            },
            label = { Text("Age") }
        )


        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.job,
            onValueChange = {
                viewModel.onJobChange(it)
            },
            label = { Text("Job") }
        )

        Row {
            Row {
                RadioButton(
                    selected = state.gender == "Male",
                    onClick = {
                        viewModel.onGenderChange("Male")
                    }
                )
                Text("Male")
            }

            Row {
                RadioButton(
                    selected = state.gender == "Female",
                    onClick = {
                        viewModel.onGenderChange("Female")
                    }
                )
                Text("Female")
            }
        }

        Button(
            onClick = {
                viewModel.saveUser()
            }
        ) {
            Text("Save")
        }

    }}
}


