package com.aya.usermanagementapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.aya.usermanagementapp.di.AppContainer
import com.aya.usermanagementapp.navigation.NavGraph
import com.aya.usermanagementapp.presentation.viewModel.AddUserViewModel
import com.aya.usermanagementapp.presentation.viewModel.UsersViewModel

class MainActivity : ComponentActivity() {

    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            val container = AppContainer(applicationContext)

            val addUserViewModel = AddUserViewModel(container.repository)

            val usersViewModel = UsersViewModel(container.repository)

            Surface(
                color = MaterialTheme.colorScheme.background
            ) {

                val navController = rememberNavController()

                NavGraph(
                    navController = navController,
                    addUserViewModel = addUserViewModel,
                    usersViewModel = usersViewModel
                )
            }
        }
    }
}