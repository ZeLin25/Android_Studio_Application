package com.example.wikifut.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wikifut.model.Team
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WikiFutViewModel : ViewModel() {

    private val _teams = MutableStateFlow<List<Team>>(emptyList())
    val teams: StateFlow<List<Team>> get() = _teams

    init {
        loadTeams()
    }

    private fun loadTeams() {
        _teams.value = listOf(
            Team(1, "Barcelona", "Espanha", "https://upload.wikimedia.org/wikipedia/en/4/47/FC_Barcelona_%28crest%29.svg", "Equipa tradicional da Espanha."),
            Team(2, "Real Madrid", "Espanha", "https://upload.wikimedia.org/wikipedia/en/5/56/Real_Madrid_CF.svg", "Maior campeão da Champions League."),
            Team(3, "Porto", "Portugal", "https://upload.wikimedia.org/wikipedia/en/6/6e/FC_Porto.svg", "Equipa Portuguesa com tradição e títulos.")
        )
    }

    fun getTeamById(id: Int): Team? = _teams.value.find { it.id == id }
}