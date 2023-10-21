package com.example.myapplication.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun DeleteButton(
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null, // You can add a content description here
            tint = Color.Red // Change the color of the icon as needed
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DeleteButtonPreview() {
    MyApplicationTheme {
        DeleteButton (onClick = {})
    }
}