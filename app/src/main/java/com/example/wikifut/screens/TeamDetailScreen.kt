package com.example.wikifut.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.wikifut.viewmodel.WikiFutViewModel

@Composable
fun TeamDetailScreen(teamId: Int) {
    val viewModel: WikiFutViewModel = viewModel()
    val team = viewModel.getTeamById(teamId)

    if (team != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = team.name, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(12.dp))
            Image(
                painter = rememberAsyncImagePainter(team.logoUrl),
                contentDescription = "Logo da equipa",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "País: ${team.country}",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = team.description)
        }
    } else {
        Text("Equipa não encontrado.")
    }
}
