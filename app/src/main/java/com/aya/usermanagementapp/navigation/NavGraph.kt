package com.aya.usermanagementapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aya.usermanagementapp.presentation.addUser.AddUserScreen
import com.aya.usermanagementapp.presentation.users.UsersScreen
import com.aya.usermanagementapp.presentation.viewModel.AddUserViewModel
import com.aya.usermanagementapp.presentation.viewModel.UsersViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    addUserViewModel: AddUserViewModel,
    usersViewModel: UsersViewModel
) {
        NavHost(
            navController = navController,
            startDestination = Screen.AddUsers.route
        ) {

            composable(Screen.AddUsers.route) {
                AddUserScreen(
                    viewModel = addUserViewModel,
                    onNavigateToUsers = {
                        navController.navigate(Screen.Users.route)
                    }
                )
            }

            composable(Screen.Users.route) {

                UsersScreen(
                    viewModel = usersViewModel
                )
            }
        }

}