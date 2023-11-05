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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.models.WorkTimeRecord
import com.example.myapplication.components.CalculateButton
import com.example.myapplication.components.WorkHoursCard
import com.example.myapplication.dialogs.TotalSalaryDialog
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewModels.SalaryCalculatorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalaryCalculatorScreen(
    salaryCalculatorViewModel: SalaryCalculatorViewModel
) {
    var showDialog by remember {
        mutableStateOf(false)
    }

    val blurRadius = if (showDialog) 10.dp else 0.dp

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    salaryCalculatorViewModel.workTimeRecords.add(WorkTimeRecord())
                }) {
                Icon(Icons.Filled.Add, "Add new work time record.")
            }
        },
    ) { innerPadding ->
        Column {
            if (salaryCalculatorViewModel.workTimeRecords.isNotEmpty()) {
                CalculateButton(
                    onClick = {
                        salaryCalculatorViewModel.totalSalary =
                            salaryCalculatorViewModel.calculateTotalSalary()
                        showDialog = !showDialog
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .blur(blurRadius)
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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

        if (showDialog) {
            TotalSalaryDialog(
                onDismissRequest = { showDialog = !showDialog },
                totalSalary = salaryCalculatorViewModel.totalSalary
            )
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