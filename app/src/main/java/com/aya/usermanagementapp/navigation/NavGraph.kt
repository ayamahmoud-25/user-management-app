package com.aya.usermanagementapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
    fun NavGraph(
        navController: NavHostController
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.AddUsers.route
        ) {

            composable(Screen.AddUsers.route) {
                AddUserScreen(
                    onNavigateToUsers = {
                        navController.navigate(Screen.Users.route)
                    }
                )
            }

            composable(Screen.Users.route) {
                UsersScreen()
            }
        }

}