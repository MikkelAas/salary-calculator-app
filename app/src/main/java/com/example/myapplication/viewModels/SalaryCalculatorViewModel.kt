package com.example.myapplication.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapplication.SalaryCalculator
import com.example.myapplication.SalaryInfo
import com.example.myapplication.WorkTimeRecord

class SalaryCalculatorViewModel : ViewModel() {

    var hourlyWage by mutableFloatStateOf(0F)

    var tax by mutableFloatStateOf(0F)

    var weekendWage by mutableFloatStateOf(0F)

    var nightWage by mutableFloatStateOf(0F)

    var workTimeRecords = mutableStateListOf<WorkTimeRecord>()

    var totalSalary by mutableFloatStateOf(0F)

    fun calculateTotalSalary(): Float {
        val salaryInfo = SalaryInfo(
            this.hourlyWage, this.tax, this.weekendWage, this.nightWage
        )

        val salaryCalculator = SalaryCalculator(salaryInfo, workTimeRecords)

        return salaryCalculator.calculateTotalSalary()
    }
}

