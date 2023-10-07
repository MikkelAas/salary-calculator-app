package com.example.myapplication.elements

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberInput(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    supportingText: String = String()
) {
    var inputValue by remember { mutableStateOf(value) }

    OutlinedTextField(
        modifier = modifier,
        value = inputValue,
        onValueChange = {
            inputValue = it
            onValueChange(it)
        },
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        supportingText = { Text(text = supportingText) },
    )
}

@Preview(showBackground = true)
@Composable
fun NumberInputPreview() {
    MyApplicationTheme(darkTheme = true) {
        NumberInput(
            label = "ExampleLabel",
            value = "",
            onValueChange = {},
            supportingText = "ExampleSupportingText"
        )
    }
}