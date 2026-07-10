package com.example.dungeondelverapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.dungeondelverapp.items.DashboardItem

@Composable
fun MainList(items: List<DashboardItem>)
{
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items) { item ->
            when (item) {
                is DashboardItem.Header -> HeaderView(item)
                is DashboardItem.UserProfile -> ProfileView(item)
                is DashboardItem.ActionButton -> ClickableLabel(item)
                is DashboardItem.CharacterTrait -> TextDisplay(item)
                is DashboardItem.Spell -> SpellView(item)
                else -> {}
            }
        }
    }
}

@Composable
fun HeaderView(item: DashboardItem.Header) {
    Text(
        text = item.title,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun ProfileView(item: DashboardItem.UserProfile) {
    Card(elevation = CardDefaults.cardElevation(), modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name, style = MaterialTheme.typography.labelMedium)
            Text(text = item.bio, style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
fun SpellView(item: DashboardItem.Spell) {
    Card(elevation = CardDefaults.cardElevation(), modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name, style = MaterialTheme.typography.titleLarge, color = Color.White)
            for (option in item.options) {
                Text(text = "AP: ${option.ap}, MP: ${option.mp}:", color = Color.White)
                Text(option.description)
            }
        }
    }
}

@Composable
fun ClickableLabel(item: DashboardItem.ActionButton)
{
    Button(
        onClick = item.onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape
    ) {
        Text(text = item.label)
    }
}

@Composable
fun TextDisplay(item: DashboardItem.CharacterTrait)
{
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Text(
        text = item.name,
        style = MaterialTheme.typography.titleMedium,
    )
    Text(text = item.description, /*style = MaterialTheme.typography.labelMedium,*/ modifier = Modifier.padding(vertical = 8.dp))
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
}