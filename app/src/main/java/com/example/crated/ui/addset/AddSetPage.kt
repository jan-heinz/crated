package com.example.crated.ui.addset

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crated.R
import com.example.crated.data.AddSetFormData
import com.example.crated.data.dummyAddSetFormData
import com.example.crated.ui.common.BackTitleTopBar
import com.example.crated.ui.theme.CratedTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSetPage(
    initialFormData: AddSetFormData = AddSetFormData(),
    onBackClick: () -> Unit = {},
    onSaveClick: () -> Unit = {},
) {
    var title by rememberSaveable { mutableStateOf(initialFormData.title) }
    var artist by rememberSaveable { mutableStateOf(initialFormData.artist) }
    var sourceUrl by rememberSaveable { mutableStateOf(initialFormData.sourceUrl) }
    var sourcePlatform by rememberSaveable { mutableStateOf(initialFormData.sourcePlatform) }
    var year by rememberSaveable { mutableStateOf(initialFormData.year) }
    var length by rememberSaveable { mutableStateOf(initialFormData.length) }
    var eventName by rememberSaveable { mutableStateOf(initialFormData.eventName) }
    var date by rememberSaveable { mutableStateOf(initialFormData.date) }
    var tags by rememberSaveable { mutableStateOf(initialFormData.tags) }
    var averageRating by rememberSaveable { mutableStateOf(initialFormData.averageRating) }
    var reviewCount by rememberSaveable { mutableStateOf(initialFormData.reviewCount) }
    var savedCount by rememberSaveable { mutableStateOf(initialFormData.savedCount) }
    var notes by rememberSaveable { mutableStateOf(initialFormData.notes) }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            BackTitleTopBar(
                title = "Add Set",
                onBackClick = onBackClick
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onSaveClick,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Image(
                    painter = painterResource(id = R.drawable.check),
                    contentDescription = "Save set"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            Text(
                text = "Add a new set to the community crate.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            AddSetTextField(
                value = title,
                onValueChange = { title = it },
                label = "Title",
                required = true
            )

            AddSetTextField(
                value = artist,
                onValueChange = { artist = it },
                label = "Artist",
                required = true
            )

            AddSetTextField(
                value = sourceUrl,
                onValueChange = { sourceUrl = it },
                label = "Source URL",
                required = true,
                keyboardType = KeyboardType.Uri
            )

            AddSetTextField(
                value = sourcePlatform,
                onValueChange = { sourcePlatform = it },
                label = "Source Platform",
                required = true,
                placeholder = "YouTube, SoundCloud, Mixcloud..."
            )

            AddSetTextField(
                value = year,
                onValueChange = { year = it },
                label = "Year",
                placeholder = "2026"
            )

            AddSetTextField(
                value = length,
                onValueChange = { length = it },
                label = "Length",
                placeholder = "62 min"
            )

            AddSetTextField(
                value = eventName,
                onValueChange = { eventName = it },
                label = "Event Name",
                placeholder = "Boiler Room, The Lot Radio..."
            )

            AddSetTextField(
                value = date,
                onValueChange = { date = it },
                label = "Date",
                placeholder = "June 13, 2026"
            )

            AddSetTextField(
                value = tags,
                onValueChange = { tags = it },
                label = "Tags",
                required = true,
                placeholder = "house, live, festival"
            )

            AddSetTextField(
                value = averageRating,
                onValueChange = { averageRating = it },
                label = "Average Rating",
                placeholder = "Leave blank until reviews exist",
                keyboardType = KeyboardType.Decimal
            )

            AddSetTextField(
                value = reviewCount,
                onValueChange = { reviewCount = it },
                label = "Review Count",
                required = true,
                keyboardType = KeyboardType.Number
            )

            AddSetTextField(
                value = savedCount,
                onValueChange = { savedCount = it },
                label = "Saved Count",
                required = true,
                keyboardType = KeyboardType.Number
            )

            AddSetTextField(
                value = notes,
                onValueChange = { notes = it },
                label = "Notes",
                minLines = 3
            )

            Spacer(modifier = Modifier.height(72.dp))
        }
    }
}

@Composable
private fun AddSetTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    required: Boolean = false,
    enabled: Boolean = true,
    placeholder: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    minLines: Int = 1,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        enabled = enabled,
        label = {
            Text(
                text = if (required) "$label (required)" else "$label (optional)"
            )
        },
        placeholder = placeholder?.let {
            { Text(text = it) }
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        minLines = minLines
    )
}

@Preview(showBackground = true)
@Composable
fun AddSetPagePreview() {
    CratedTheme {
        AddSetPage(initialFormData = dummyAddSetFormData)
    }
}
