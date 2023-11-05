package com.example.myapplication.components

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.models.WorkTimeRecord
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.time.LocalDate

@Composable
fun WorkHoursCard(
    onHoursInputChange: (String) -> Unit,
    onBonusInputChange: (String) -> Unit,
    onWeekendHoursInputChange: (String) -> Unit,
    onNightHoursInputChange: (String) -> Unit,
    deleteButtonOnClick: () -> Unit,
    workTimeRecord: WorkTimeRecord
) {
    val context = LocalContext.current

    val calendar = Calendar.getInstance()

    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

    var isExpanded by remember {
        mutableStateOf(true)
    }

    val year = calendar[Calendar.YEAR]
    val month = calendar[Calendar.MONTH]
    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]

    val datePicker = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            selectedDate = LocalDate.of(selectedYear, selectedMonth+1, selectedDayOfMonth)
        },
        year,
        month,
        dayOfMonth
    )

    Card(
        modifier = Modifier
            .padding(20.dp)
            .width(400.dp)
    ) {
        if (isExpanded) {

            IconButton(onClick = { isExpanded = !isExpanded }) {
                Icon(Icons.Filled.KeyboardArrowUp, "Drop down arrow")
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
            ) {


                NumberInput(
                    label = "Antall timer totalt",
                    value = (
                            if (workTimeRecord.hours == 0F) ""
                            else workTimeRecord.hours.toString()
                            ),
                    onValueChange = onHoursInputChange
                )
                NumberInput(
                    label = "Bonus i %",
                    value = (
                            if (workTimeRecord.bonusInPercent == null) ""
                            else workTimeRecord.bonusInPercent.toString()
                            ),
                    onValueChange = onBonusInputChange
                )
                NumberInput(
                    label = "Antall timer helg",
                    value = (
                            if (workTimeRecord.weekendHours.equals(0F)) ""
                            else workTimeRecord.weekendHours.toString()
                            ),
                    onValueChange = onWeekendHoursInputChange
                )
                NumberInput(
                    label = "Antall timer natt",
                    value = (
                            if (workTimeRecord.nightHours.equals(0F)) ""
                            else workTimeRecord.nightHours.toString()
                            ),
                    onValueChange = onNightHoursInputChange
                )

                TextButton(
                    onClick = {
                        datePicker.show()
                    }) {
                    Text(text = if (selectedDate == null) "Velg dato" else selectedDate.toString())
                }
            }

            DeleteButton(onClick = deleteButtonOnClick)
        } else {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(onClick = { isExpanded = !isExpanded }) {
                    Icon(Icons.Filled.KeyboardArrowDown, "Drop down arrow")
                }
                TextButton(
                    onClick = {
                        datePicker.show()
                    }) {
                    Text(text = if (selectedDate == null) "Velg dato" else selectedDate.toString())
                }

                DeleteButton(onClick = deleteButtonOnClick)
            }
        }
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