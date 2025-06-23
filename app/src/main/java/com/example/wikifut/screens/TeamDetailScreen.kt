package com.example.wikifut.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import coil.compose.rememberAsyncImagePainter
import com.example.wikifut.viewmodel.WikiFutViewModel

@Composable
fun TeamDetailScreen(backStackEntry: NavBackStackEntry, viewModel: WikiFutViewModel = viewModel()) {
    val teamId = backStackEntry.arguments?.getString("teamId")?.toIntOrNull()
    val team = teamId?.let { viewModel.getTeamById(it) }

    team?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(it.logoUrl),
                contentDescription = it.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(it.name, style = MaterialTheme.typography.headlineSmall)
            Text(it.country, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(it.description, style = MaterialTheme.typography.bodyMedium)
        }
    } ?: Text("Equipas não encontrado.")
}