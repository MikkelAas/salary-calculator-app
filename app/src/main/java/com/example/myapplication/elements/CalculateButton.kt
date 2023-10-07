package com.example.myapplication.elements

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun CalculateButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val buttonTitle = "KALKULER"

    ElevatedButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = buttonTitle)
    }
}

@Preview(showBackground = true)
@Composable
fun CalculateButtonPreview() {
    MyApplicationTheme {
        CalculateButton(onClick = { })
    }
}