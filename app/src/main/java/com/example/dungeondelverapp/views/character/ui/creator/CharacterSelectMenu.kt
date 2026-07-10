package com.example.dungeondelverapp.views.character.ui.creator

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dungeondelverapp.utils.renderString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDropDownMenu(
    identifier: Int,
    list: List<Int>,
    selectedOption: String,
    onValueChange: (String) -> Unit,
)
{
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = (if (selectedOption == "") renderString(identifier) else selectedOption),
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            list.forEach { option ->
                DropdownMenuItem(
                    text = { Text(stringResource(id = option)) },
                    onClick = {
                        expanded = false
                        onValueChange(renderString(option))
                    }
                )
            }
        }
    }
}