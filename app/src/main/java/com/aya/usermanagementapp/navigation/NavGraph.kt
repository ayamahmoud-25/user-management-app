package com.aya.usermanagementapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aya.usermanagementapp.presentation.addUser.AddUserScreen
import com.aya.usermanagementapp.presentation.viewModel.AddUserViewModel

@Composable
    fun NavGraph(
        navController: NavHostController,
        viewModel: AddUserViewModel

) {
        NavHost(
            navController = navController,
            startDestination = Screen.AddUsers.route
        ) {

            composable(Screen.AddUsers.route) {
                AddUserScreen(
                    viewModel = viewModel,
                    onNavigateToUsers = {
                        navController.navigate(Screen.Users.route)
                    }
                )
            }

            composable(Screen.Users.route) {
                //UsersScreen()
            }
        }

}