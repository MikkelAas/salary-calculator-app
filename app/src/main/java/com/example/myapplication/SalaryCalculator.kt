package com.example.myapplication

import com.example.myapplication.models.SalaryInfo
import com.example.myapplication.models.WorkTimeRecord

class SalaryCalculator(
    var salaryInfo: SalaryInfo,
    var workTimeRecords: MutableList<WorkTimeRecord> = mutableListOf()
) {
    fun calculateTotalSalary(): Float {
        var total = 0F

        for (workTimeRecord in workTimeRecords) {
            var bonus = workTimeRecord.bonusInPercent

            bonus = if (bonus != null) {
                (bonus + 100) / 100
            } else {
                1F
            }

            total += (
                    workTimeRecord.hours * (bonus) * salaryInfo.hourlyWage
                            + (workTimeRecord.weekendHours * salaryInfo.weekendWage)
                            + (workTimeRecord.nightHours * salaryInfo.nightWage)
                    )
        }

        if (salaryInfo.tax != null) {
            return total * ((100 - salaryInfo.tax!!) / 100)
        }

        return total
    }
}