package com.example.ticketapp.Nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ticketapp.ui.HomeMenu.MainScreen
import com.example.ticketapp.ui.cliente.ClientRegisterScreen
import com.example.ticketapp.ui.cliente.ClienteScreen

@Composable
fun AppNavigation(context: Context,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.MainScreen.route
    ) {
        //Home Screen
        composable(AppScreens.ClienteScreen.route) {
            ClienteScreen(navController = navController)
        }
        composable(AppScreens.ClientRegisterScreen.route) {
            ClientRegisterScreen(navController = navController)
        }
        composable(AppScreens.MainScreen.route) {
            MainScreen(navController = navController)
        }


    }
}