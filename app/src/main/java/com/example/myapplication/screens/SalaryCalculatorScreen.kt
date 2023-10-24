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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.WorkTimeRecord
import com.example.myapplication.components.CalculateButton
import com.example.myapplication.components.TotalSalaryCard
import com.example.myapplication.components.WorkHoursCard
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewModels.SalaryCalculatorViewModel

@Composable
fun SalaryCalculatorScreen(
    modifier: Modifier = Modifier,
    salaryCalculatorViewModel: SalaryCalculatorViewModel
) {
    FloatingActionButton(onClick = {
        salaryCalculatorViewModel.workTimeRecords.add(WorkTimeRecord())
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

        CalculateButton(
            onClick = {
                salaryCalculatorViewModel.totalSalary =
                    salaryCalculatorViewModel.calculateTotalSalary()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )


        TotalSalaryCard(salaryCalculatorViewModel.totalSalary)




        LazyColumn() {
            items(salaryCalculatorViewModel.workTimeRecords) { workTimeRecord ->
                WorkHoursCard(
                    workTimeRecord = workTimeRecord,
                    onHoursInputChange = {
                        workTimeRecord.hours = it.toFloatOrNull() ?: 0F
                    },
                    onBonusInputChange = {
                        workTimeRecord.bonusInPercent = it.toFloatOrNull()
                    },
                    onWeekendHoursInputChange = {
                        workTimeRecord.weekendHours = it.toFloatOrNull() ?: 0F
                    },
                    onNightHoursInputChange = {
                        workTimeRecord.nightHours = it.toFloatOrNull() ?: 0F
                    },
                    deleteButtonOnClick = {
                        salaryCalculatorViewModel.workTimeRecords.remove(workTimeRecord)
                    }
                )
                
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SalaryCalculatorScreenPreview() {
    MyApplicationTheme {
        SalaryCalculatorScreen(salaryCalculatorViewModel = viewModel())
    }
}