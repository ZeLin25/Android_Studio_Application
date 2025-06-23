package com.example.wikifut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.wikifut.ui.screens.HomeScreen
import com.example.wikifut.ui.screens.TeamDetailScreen
import com.example.wikifut.ui.theme.WikiFutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WikiFutTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController)
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("teamDetail/{teamId}") { backStackEntry ->
            TeamDetailScreen(backStackEntry)
        }
    }
}