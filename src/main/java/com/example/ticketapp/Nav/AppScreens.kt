package com.example.ticketapp.Nav

sealed class AppScreens(val route : String) {
    object ClientRegisterScreen: AppScreens("register_screen")
    object ClienteScreen: AppScreens("consult_screen")
    object MainScreen: AppScreens("main_screen")

}