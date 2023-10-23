package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.WorkTimeRecord
import com.example.myapplication.components.CalculateButton
import com.example.myapplication.components.TotalSalaryCard
import com.example.myapplication.components.WorkHoursCard
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun SalaryCalculatorScreen(modifier: Modifier = Modifier) {
    val workTimeRecords = remember {
        mutableStateListOf<WorkTimeRecord>()
    }

    val totalSalary by remember {
        mutableFloatStateOf(0F)
    }

    val showResult by remember {
        mutableStateOf(false)
    }

    FloatingActionButton(onClick = {
        workTimeRecords.add(WorkTimeRecord())
    }) {
        Icon(Icons.Filled.Add, "Add new work time record.")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Antall timer jobbet",
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(5.dp))

        LazyColumn() {
            items(workTimeRecords) {
                WorkHoursCard(
                    onHoursInputChange = {},
                    onBonusInputChange = {},
                    onWeekendHoursInputChange = {},
                    onNightHoursInputChange = {},
                    deleteButtonOnClick = {
                        workTimeRecords.remove(it)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        CalculateButton(
            onClick = {
                /* TODO calculate salary */
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        if (showResult) {
            TotalSalaryCard(totalSalary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SalaryCalculatorScreenPreview() {
    MyApplicationTheme {
        SalaryCalculatorScreen()
    }
}