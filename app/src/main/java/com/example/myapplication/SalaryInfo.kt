package com.example.myapplication


data class SalaryInfo(
    var hourlyWage: Float = 0F,
    var tax: Float? = null,
    var weekendWage: Float = 0F,
    var nightWage: Float = 0F,
)
