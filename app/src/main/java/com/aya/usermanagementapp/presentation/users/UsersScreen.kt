package com.aya.usermanagementapp.presentation.users

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.aya.usermanagementapp.presentation.viewModel.UsersViewModel
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
@Composable
fun UsersScreen(
    viewModel: UsersViewModel
) {
    val uiState = viewModel.uiState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Users List")

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, androidx.compose.ui.graphics.Color.Gray)
                .padding(8.dp)
        ) {
            Text("Name", modifier = Modifier.weight(1f))
            Text("Age", modifier = Modifier.weight(1f))
            Text("Job", modifier = Modifier.weight(1f))
            Text("Gender", modifier = Modifier.weight(1f))
        }

        LazyColumn {
            items(uiState.users) { user ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, androidx.compose.ui.graphics.Color.LightGray)
                        .padding(8.dp)
                ) {
                    Text(user.name, modifier = Modifier.weight(1f))
                    Text(user.age.toString(), modifier = Modifier.weight(1f))
                    Text(user.jobTitle, modifier = Modifier.weight(1f))
                    Text(user.gender, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}