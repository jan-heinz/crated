package com.example.crated.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.crated.data.dummySets
import com.example.crated.model.Set

class HomeViewModel : ViewModel() {
    var searchQuery by mutableStateOf("")
        private set

    val visibleSets: List<Set>
        get() {
            val query = searchQuery.trim()
            if (query.isEmpty()) return dummySets

            return dummySets.filter { set ->
                set.title.contains(query, ignoreCase = true) ||
                    set.artist.contains(query, ignoreCase = true) ||
                    set.sourcePlatform.contains(query, ignoreCase = true)
            }
        }

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
    }
}
