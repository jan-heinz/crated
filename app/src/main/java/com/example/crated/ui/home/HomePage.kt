package com.example.crated.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.crated.R
import com.example.crated.ui.common.CrateSearchBar
import com.example.crated.ui.common.CratedTopBar
import com.example.crated.ui.common.SetCard
import com.example.crated.ui.theme.CratedTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    viewModel: HomeViewModel = viewModel(),
    onNavigateToUser: () -> Unit = {},
    onNavigateToCreateSet: () -> Unit = {},
    onNavigateToReviewSet: (String) -> Unit = {},
) {
    Scaffold(
        topBar = {
            CratedTopBar(onProfileClick = onNavigateToUser)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToCreateSet,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                // FAB for set creation
                Image(
                    painter = painterResource(R.drawable.add),
                    contentDescription = "Add set")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            CrateSearchBar(
                query = viewModel.searchQuery,
                onQueryChange = { viewModel.onSearchQueryChange(it) }
            )
            
            Text(
                text = "Hot pulls from the crate",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.SemiBold
            )
            
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 80.dp
                )
            ) {
                if (viewModel.visibleSets.isEmpty()) {
                    item {
                        EmptySetResults()
                    }
                } else {
                    items(
                        items = viewModel.visibleSets,
                        key = { set -> set.id }
                    ) { set ->
                        SetCard(
                            set = set,
                            onClick = { onNavigateToReviewSet(set.id) },
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun EmptySetResults() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "No sets found.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    CratedTheme {
        HomePage()
    }
}
