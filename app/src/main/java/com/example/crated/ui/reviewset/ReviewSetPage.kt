package com.example.crated.ui.reviewset

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crated.R
import com.example.crated.data.ReviewSetFormData
import com.example.crated.data.dummyReviewSetFormData
import com.example.crated.data.dummySets
import com.example.crated.model.Set
import com.example.crated.ui.common.BackTitleTopBar
import com.example.crated.ui.common.SetCard
import com.example.crated.ui.theme.CratedTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewSetPage(
    set: Set,
    initialFormData: ReviewSetFormData = ReviewSetFormData(),
    onBackClick: () -> Unit = {},
    onSaveClick: () -> Unit = {},
) {
    var reviewText by rememberSaveable { mutableStateOf(initialFormData.reviewText) }
    var customTags by rememberSaveable { mutableStateOf(initialFormData.customTags) }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            BackTitleTopBar(
                title = "Review Set",
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
                    contentDescription = "Save review"
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
            SetCard(
                set = set,
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Your Rating",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            VinylRatingRow(rating = initialFormData.rating)

            Spacer(modifier = Modifier.height(28.dp))

            OutlinedTextField(
                value = reviewText,
                onValueChange = { reviewText = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Write a review") },
                minLines = 5,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = customTags,
                onValueChange = { customTags = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Custom tags") },
                placeholder = { Text("techno, great audio, incomplete") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(72.dp))
        }
    }
}

@Composable
private fun VinylRatingRow(
    rating: Float,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(5) { index ->
            VinylRatingCircle(
                fillAmount = when {
                    rating >= index + 1 -> 1f
                    rating >= index + 0.5f -> 0.5f
                    else -> 0f
                }
            )
        }
    }
}

@Composable
private fun VinylRatingCircle(
    fillAmount: Float,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(56.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
    ) {
        if (fillAmount > 0f) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(fillAmount)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewSetPagePreview() {
    CratedTheme {
        ReviewSetPage(
            set = dummySets.first(),
            initialFormData = dummyReviewSetFormData
        )
    }
}
