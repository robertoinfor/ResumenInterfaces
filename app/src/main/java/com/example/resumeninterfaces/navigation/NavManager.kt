package com.example.resumeninterfaces.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.resumeninterfaces.views.DetailView
import com.example.resumeninterfaces.views.InicioListas
import com.example.resumeninterfaces.views.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            InicioListas(navController)
        }
        composable("Home2"){
            HomeView(navController)
        }
        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id"){
                type = NavType.IntType
            },
            navArgument("opcional"){
                type = NavType.StringType
            }

        )){
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""
            DetailView(navController, id, opcional)
        }
    }
}