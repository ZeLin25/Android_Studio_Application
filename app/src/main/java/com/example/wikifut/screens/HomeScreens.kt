package com.example.wikifut.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.wikifut.ui.components.TeamCard
import com.example.wikifut.viewmodel.WikiFutViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: WikiFutViewModel = viewModel()) {
    val teams by viewModel.teams.collectAsState()

    LazyColumn {
        items(teams) { team ->
            TeamCard(team = team) {
                navController.navigate("teamDetail/${team.id}")
            }
        }
    }
}
