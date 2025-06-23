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
            Team(1, "Barcelona", "Espanha", "https://upload.wikimedia.org/wikipedia/pt/thumb/4/43/FCBarcelona.svg/140px-FCBarcelona.svg.png",
                "Nacionalmente, o Barcelona conquistou 28 vezes a La Liga, 32 Copa del Rey, 14 Supercopa da Espanha, três Copa Eva Duarte e duas vezes a Copa da Liga Espanhola, sendo o detentor do maior número de troféus nas quatro últimas competições citadas. No que diz respeito ao futebol internacional, o clube sagrou-se vencedor da Liga dos Campeões da UEFA cinco vezes, e cinco triunfos da Supercopa da UEFA e quatro a Taça dos Clubes Vencedores de Taças, três a Taça das Cidades com Feiras, dois a Taça Latina, e por último três a Copa do Mundo de Clubes da FIFA. O Barcelona esteve na primeira posição do ranking mundial de clubes da IFFHS em 1997, 2009, 2011, 2012 e 2015, e atualmente ocupa a segunda posição no ranking de clubes da UEFA. A principal rivalidade do time é com o Real Madrid, onde as partidas entre as duas equipes são chamada de El Clásico."),
            Team(2, "Real Madrid", "Espanha", "https://upload.wikimedia.org/wikipedia/pt/thumb/9/98/Real_Madrid.png/120px-Real_Madrid.png", "É uma das entidades mais premiadas e reconhecidas do mundo, recebendo no futebol o título de melhor clube do Século XX pela FIFA, em dezembro de 2000 e o primeiro entre todos clubes espanhóis, e o título de melhor clube europeu do Século XX pela IFFHS, em maio de 2010. Entre suas maiores conquistas, o clube detém de 36 títulos da La Liga (um recorde), 20 títulos da Copa del Rey, 12 títulos da Supercopa da Espanha, um título da Copa da Liga Espanhola e um título da Copa Eva Duarte. Em nível internacional, o clube venceu 15 títulos europeus da Taça dos Clubes Campeões Europeus/Liga dos Campeões da UEFA, sendo o maior campeão do torneio, dois títulos da Liga Europa da UEFA, seis títulos da Supercopa da UEFA, dois títulos da Taça Latina, um título da Copa Ibero-Americana, três títulos da Copa Intercontinental, cinco títulos da Copa do Mundo de Clubes da FIFA e um título da Copa Intercontinental da FIFA."),
            Team(3, "Porto", "Portugal", "https://upload.wikimedia.org/wikipedia/pt/thumb/c/c5/F.C._Porto_logo.png/120px-F.C._Porto_logo.png", "O FC Porto é o clube português com mais troféus oficiais ganhos pela equipa de futebol profissional, com um total de 86. O FC Porto é atualmente a equipa portuguesa com mais sucesso internacionalmente, tendo ganho sete troféus, 5 europeus e 2 intercontinentais, um recorde no futebol português: a Taça dos Campeões Europeus/Liga dos Campeões da UEFA em 1986/87 e 2003/04; a Taça UEFA/Liga Europa da UEFA em 2002/03 e 2010/11; a Supertaça Europeia em 1987, a Taça Intercontinental em 1987 e 2004. É o único clube português que ganhou três das quatro últimas competições referidas e a conseguir uma tripla continental: liga doméstica, taça e título europeu (2002/03 e 2010/11). Além disso, foi vice-campeão da Taça das Taças em 1984, a sua primeira final europeia, e por 3 vezes da Supertaça Europeia, em 2003, 2004 e 2011. Internamente, ganhou 30 troféus da Primeira Liga, 20 Taças de Portugal, 24 Supertaças Cândido de Oliveira, 1 Taça da Liga e venceu por 4 vezes o extinto Campeonato de Portugal."),
            Team(4, "Benfica", "Portugal", "https://upload.wikimedia.org/wikipedia/pt/thumb/d/de/Sport_Lisboa_e_Benfica.svg/250px-Sport_Lisboa_e_Benfica.svg.png", "A nível internacional no futebol masculino sénior (primeiro escalão), o clube conquistou duas Taças dos Campeões Europeus, ambas no início dos anos sessenta (épocas 1960–61 e 1961–62), a segunda delas com a ajuda do lendário Eusébio, um eterno símbolo benfiquista, que após o final da sua carreira se tornou um embaixador itinerante do Benfica e de Portugal."),
            Team(5, "Sporting", "Portugal", "https://upload.wikimedia.org/wikipedia/pt/thumb/3/3e/Sporting_Clube_de_Portugal.png/120px-Sporting_Clube_de_Portugal.png", "Apesar de possuir várias modalidades, o Sporting é conhecido sobretudo pela sua equipa principal de futebol que foi por 21 vezes campeão nacional, que venceu por 4 vezes o Campeonato de Portugal, por 18 vezes a Taça de Portugal, 9 vezes a Supertaça, 1 vez a Taça Império e ainda venceu 4 vezes a Taças da Liga.")
        )
    }

    fun getTeamById(id: Int): Team? = _teams.value.find { it.id == id }
}