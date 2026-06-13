package com.example.crated.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crated.R
import com.example.crated.data.ProfileListItemData
import com.example.crated.data.dummyActivityItems
import com.example.crated.data.dummyCrateItems
import com.example.crated.data.dummyReviewItems
import com.example.crated.ui.common.UserProfileTopBar
import com.example.crated.ui.theme.CratedTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfilePage(
    username: String,
    bio: String? = null,
    savedCount: Int = 0,
    reviewCount: Int = 0,
    crateCount: Int = 0,
    onBackClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
) {
    var selectedTab by rememberSaveable { mutableStateOf(ProfileTab.Activity) }

    Scaffold(
        topBar = {
            UserProfileTopBar(
                onBackClick = onBackClick,
                onSettingsClick = onSettingsClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserProfileHeader(
                username = username,
                bio = bio
            )

            Spacer(modifier = Modifier.height(24.dp))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.outlineVariant
            )

            Spacer(modifier = Modifier.height(24.dp))

            ProfileStatsRow(
                savedCount = savedCount,
                reviewCount = reviewCount,
                crateCount = crateCount
            )

            Spacer(modifier = Modifier.height(24.dp))

            ProfileTabs(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )

            ProfileTabContent(
                selectedTab = selectedTab,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun UserProfileHeader(
    username: String,
    bio: String?,
) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "User profile picture",
        modifier = Modifier
            .size(112.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(18.dp)
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = username,
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold
    )

    if (!bio.isNullOrBlank()) {
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = bio,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun ProfileStatsRow(
    savedCount: Int,
    reviewCount: Int,
    crateCount: Int,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProfileStatBox(
            label = "Saved",
            count = savedCount,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(12.dp))

        ProfileStatBox(
            label = "Reviews",
            count = reviewCount,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(12.dp))

        ProfileStatBox(
            label = "Crates",
            count = crateCount,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun ProfileStatBox(
    label: String,
    count: Int,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = count.toString(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun ProfileTabs(
    selectedTab: ProfileTab,
    onTabSelected: (ProfileTab) -> Unit,
) {
    PrimaryTabRow(
        selectedTabIndex = selectedTab.ordinal,
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        ProfileTab.entries.forEach { tab ->
            Tab(
                selected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                text = { Text(tab.label) }
            )
        }
    }
}

@Composable
private fun ProfileTabContent(
    selectedTab: ProfileTab,
    modifier: Modifier = Modifier,
) {
    val items = when (selectedTab) {
        ProfileTab.Activity -> dummyActivityItems
        ProfileTab.Reviews -> dummyReviewItems
        ProfileTab.Crates -> dummyCrateItems
    }

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items) { item ->
            ProfileListItem(item = item)
        }
    }
}

@Composable
private fun ProfileListItem(
    item: ProfileListItemData,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = item.action,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = item.title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold
            )

            if (item.detail.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.detail,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

private enum class ProfileTab(val label: String) {
    Activity("Activity"),
    Reviews("Reviews"),
    Crates("Crates")
}

@Preview(showBackground = true)
@Composable
fun UserProfilePagePreview() {
    CratedTheme {
        UserProfilePage(
            username = "janheinz",
            bio = "techno trance lover",
            savedCount = 42,
            reviewCount = 18,
            crateCount = 6
        )
    }
}
