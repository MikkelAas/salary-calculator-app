package com.example.myapplication.components

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun WorkHoursCard(
    onHoursInputChange: (String) -> Unit,
    onBonusInputChange: (String) -> Unit,
    onWeekendHoursInputChange: (String) -> Unit,
    onNightHoursInputChange: (String) -> Unit,
    deleteButtonOnClick: () -> Unit,
) {
    Card {
            NumberInput(label = "Antall timer totalt", value = "", onValueChange = onHoursInputChange)
            NumberInput(label = "Bonus i %", value = "", onValueChange = onBonusInputChange)
            NumberInput(label = "Antall timer helg", value = "", onValueChange = onWeekendHoursInputChange)
            NumberInput(label = "Antall timer natt", value = "", onValueChange = onNightHoursInputChange)
            DeleteButton(onClick = deleteButtonOnClick)
    }
}

@Preview(showBackground = true)
@Composable
fun WorkHoursCardPreview() {
    MyApplicationTheme {
        WorkHoursCard(
            onHoursInputChange = {},
            onBonusInputChange = {},
            onWeekendHoursInputChange = {},
            onNightHoursInputChange = {},
            deleteButtonOnClick = {}
        )
    }
}