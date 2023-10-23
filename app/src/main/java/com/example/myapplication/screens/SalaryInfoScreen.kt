package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.components.NumberInput
import com.example.myapplication.viewModels.SalaryCalculatorViewModel

@Composable
fun SalaryInfoScreen(salaryCalculatorViewModel: SalaryCalculatorViewModel) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(state = scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(16.dp))

        NumberInput(
            label = "Timelønn",
            value = salaryCalculatorViewModel.hourlyWage.toString(),
            onValueChange = {
                salaryCalculatorViewModel.hourlyWage = it.toFloatOrNull() ?: 0F
            }, supportingText = "Timelønn i NOK"
        )

        NumberInput(
            label = "Skatt",
            value = "",
            onValueChange = {
                salaryCalculatorViewModel.tax = it.toFloatOrNull() ?: 0F
            },
            supportingText = "Skatt i %"
        )

        NumberInput(
            label = "Helgetillegg",
            value = "",
            onValueChange = {
                salaryCalculatorViewModel.weekendWage = it.toFloatOrNull() ?: 0F
            }, supportingText = "Helgetillegg i NOK"
        )


        NumberInput(
            label = "Kvelds- og nattillegg",
            value = "",
            onValueChange = {
                salaryCalculatorViewModel.nightWage = it.toFloatOrNull() ?: 0F
            },
            supportingText = "Kvelds- og nattillegg i NOK"
        )
    }
}