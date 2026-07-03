package com.aya.usermanagementapp.navigation

sealed class Screen(val route: String) {
    object AddUsers : Screen("add_user");

    object Users : Screen("users");
}