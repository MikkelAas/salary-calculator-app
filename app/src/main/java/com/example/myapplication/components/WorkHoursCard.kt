package com.example.myapplication.components

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.WorkTimeRecord
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun WorkHoursCard(
    onHoursInputChange: (String) -> Unit,
    onBonusInputChange: (String) -> Unit,
    onWeekendHoursInputChange: (String) -> Unit,
    onNightHoursInputChange: (String) -> Unit,
    deleteButtonOnClick: () -> Unit,
    workTimeRecord: WorkTimeRecord
) {
    Card {
        NumberInput(
            label = "Antall timer totalt",
            value = workTimeRecord.hours.toString(),
            onValueChange = onHoursInputChange
        )
        NumberInput(
            label = "Bonus i %",
            value = workTimeRecord.bonusInPercent.toString(),
            onValueChange = onBonusInputChange
        )
        NumberInput(
            label = "Antall timer helg",
            value = workTimeRecord.weekendHours.toString(),
            onValueChange = onWeekendHoursInputChange
        )
        NumberInput(
            label = "Antall timer natt",
            value = workTimeRecord.nightHours.toString(),
            onValueChange = onNightHoursInputChange
        )
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
            deleteButtonOnClick = {},
            workTimeRecord = WorkTimeRecord()
        )
    }
}