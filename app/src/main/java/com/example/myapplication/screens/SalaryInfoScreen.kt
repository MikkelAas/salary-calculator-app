package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.components.NumberInput

@Composable
fun SalaryInfoScreen() {

    Box {
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
                }, supportingText = "Timelønn i NOK"
            )


            NumberInput(
                label = "Skatt",
                value = "",
                onValueChange = {
                },
                supportingText = "Skatt i %"
            )

            NumberInput(
                label = "Helgetillegg",
                value = "",
                onValueChange = {

                }, supportingText = "Helgetillegg i NOK"
            )


            NumberInput(
                label = "Kvelds- og nattillegg",
                value = "",
                onValueChange = {
                },
                supportingText = "Kvelds- og nattillegg i NOK"
            )
        }
    }
}