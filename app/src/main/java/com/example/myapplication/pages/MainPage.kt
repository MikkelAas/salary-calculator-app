package com.example.myapplication.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.Salary
import com.example.myapplication.WorkTimeRecord
import com.example.myapplication.elements.CalculateButton
import com.example.myapplication.elements.NumberInput
import com.example.myapplication.elements.TotalSalaryCard
import com.example.myapplication.elements.WorkHoursCard
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun SalaryCalculator(modifier: Modifier = Modifier) {
    val workTimeRecords = mutableListOf(WorkTimeRecord(), WorkTimeRecord())

    val salary by remember {
        mutableStateOf(
            Salary(
                workTimeRecords = workTimeRecords
            )
        )
    }

    var totalSalary by remember {
        mutableStateOf(0F)
    }

    var showResult by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            NumberInput(
                label = "Timelønn",
                value = "",
                onValueChange = {
                    salary.hourlyWage = it.toFloatOrNull() ?: 0F
                    showResult = false
                }, supportingText = "Timelønn i NOK"
            )


            NumberInput(
                label = "Skatt",
                value = "",
                onValueChange = {
                    salary.tax = it.toFloatOrNull()
                },
                supportingText = "Skatt i %"
            )

            NumberInput(
                label = "Helgetillegg",
                value = "",
                onValueChange = {
                    salary.weekendWage = it.toFloatOrNull() ?: 0F
                    showResult = false
                }, supportingText = "Helgetillegg i NOK"
            )


            NumberInput(
                label = "Kvelds- og nattillegg",
                value = "",
                onValueChange = {
                    salary.tax = it.toFloatOrNull()
                },
                supportingText = "Kvelds- og nattillegg i NOK"
            )


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Antall timer jobbet",
                modifier = modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(5.dp))


            Column {
                for (workTimeRecord in salary.workTimeRecords) {
                    WorkHoursCard(
                        onHoursInputChange = {},
                        onBonusInputChange = {},
                        onWeekendHoursInputChange = {},
                        onNightHoursInputChange = {},
                        deleteButtonOnClick = {}
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            CalculateButton(
                onClick = {
                    totalSalary = salary.calculateTotalSalary()
                    showResult = true
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            if (showResult) {
                TotalSalaryCard(totalSalary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SalaryCalculatorPreview() {
    MyApplicationTheme {
        SalaryCalculator()
    }
}