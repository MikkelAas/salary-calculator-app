package com.example.myapplication.elements

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun TotalSalaryCard(totalSalary: Float) {
    Card {
        Text(
            text = "Total lønn 💰: ${totalSalary}kr",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = TextUnit(18F, TextUnitType.Sp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TotalSalaryCardPreview(){
    MyApplicationTheme {
        TotalSalaryCard(totalSalary = 100F)
    }
}
