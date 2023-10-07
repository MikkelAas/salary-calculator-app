package com.example.myapplication.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.myapplication.Salary
import com.example.myapplication.elements.CalculateButton
import com.example.myapplication.elements.NumberInput
import com.example.myapplication.elements.TotalSalaryCard
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun SalaryCalculator(modifier: Modifier = Modifier) {
    val salary by remember {
        mutableStateOf(
            Salary()
        )
    }

    var totalSalary by remember {
        mutableStateOf(0F)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Lønnskalkulator 🤑🤑🤑",
            fontSize = TextUnit(24F, TextUnitType.Sp),
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        NumberInput(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = "Timelønn",
            value = "",
            onValueChange = {
                salary.baseSalary = it.toFloatOrNull() ?: 0F
            }, supportingText = "Timelønn i NOK"
        )

        Spacer(modifier = Modifier.height(7.dp))

        NumberInput(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = "Skatt",
            value = "",
            onValueChange = {
                salary.tax = it.toFloatOrNull()
            },
            supportingText = "Skatt i %"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Antall timer jobbet",
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(5.dp))

        NumberInput(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = "Vanlige timer",
            value = "",
            onValueChange = {
                salary.normalHours = it.toFloatOrNull() ?: 0F
            }
        )

        NumberInput(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = "50% bonus timer",
            value = "",
            onValueChange = {
                salary.fiftyPercentHours = it.toFloatOrNull() ?: 0F
            }
        )

        NumberInput(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = "100% bonus timer",
            value = "",
            onValueChange = {
                salary.hundredPercentHours = it.toFloatOrNull() ?: 0F
            },
        )

        NumberInput(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = "150% bonus timer",
            value = "",
            onValueChange = {
                salary.oneFiftyPercentHours = it.toFloatOrNull() ?: 0F
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CalculateButton(
            onClick = {
                totalSalary = salary.calculateTotalSalary()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TotalSalaryCard(totalSalary)
    }
}

@Preview(showBackground = true)
@Composable
fun SalaryCalculatorPreview() {
    MyApplicationTheme {
        SalaryCalculator()
    }
}